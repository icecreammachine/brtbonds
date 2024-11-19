package com.icecreammachine.brtbonds.job;

import com.icecreammachine.brtbonds.dao.BondHistoryLinkDAO;
import com.icecreammachine.brtbonds.dao.SysParametersDAO;
import com.icecreammachine.brtbonds.entity.BondHistoryLink;
import com.icecreammachine.brtbonds.entity.BondType;
import com.icecreammachine.brtbonds.entity.SysParameters;
import com.icecreammachine.brtbonds.network.CrunchifyDownloadFileFromURL;
import com.icecreammachine.brtbonds.processing.ProcessExcelFile;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class JobDownloadHistoricalPricesRates {

    private static final Logger logger = LoggerFactory.getLogger(
        JobDownloadHistoricalPricesRates.class
    );

    @Autowired
    BondHistoryLinkDAO linkHistoricoDAO;

    @Autowired
    SysParametersDAO sysParametersDAO;

    @Autowired
    ProcessExcelFile processExcelFile;

    @Scheduled(cron = "0 0 12 * * MON-FRI")
    public void execute() {
        Optional<SysParameters> paramFirstRun = sysParametersDAO.findById(
            "FIRST_RUN"
        );
        String firstRun = paramFirstRun.get().getValue();

        List<BondHistoryLink> listLink = null;

        // First system run, process all spreadsheets since 2002
        if (firstRun.equals("Y")) {
            listLink = (List<BondHistoryLink>) linkHistoricoDAO.findAll();
        }
        // Process only spreadsheets from current year
        else {
            listLink = linkHistoricoDAO.findByYear(LocalDate.now().getYear());
        }

        // Bond type
        List<BondType> bondType = new ArrayList<BondType>();

        // Spreadsheets to process
        List<String> spreadSheets = new ArrayList<String>();

        BondHistoryLink bondHistoryLink = null;

        String tempDirectory = System.getProperty("java.io.tmpdir");

        // Download files
        for (int i = 0; i < listLink.size(); i++) {
            try {
                bondHistoryLink = listLink.get(i);
                String fileURL = bondHistoryLink.getLink();
                String fileName = fileURL.substring(
                    fileURL.lastIndexOf("/") + 1,
                    fileURL.length()
                );
                String filePath = tempDirectory + File.separator + fileName;

                File f = new File(filePath);

                if (!f.exists()) {
                    CrunchifyDownloadFileFromURL.downloadFile(
                        fileURL,
                        filePath
                    );
                }

                if (f.exists()) {
                    bondType.add(bondHistoryLink.getBondType());
                    spreadSheets.add(filePath);
                }
            } catch (Exception e) {
                logger.error("execute(): Error downloading file ", e);
            }
        }

        Boolean processedAll = true;

        // Process spreadsheet data
        for (int i = 0; i < spreadSheets.size(); i++) {
            try {
                processExcelFile.processHistoricSpreadsheet(
                    spreadSheets.get(i),
                    bondType.get(i)
                );
            } catch (Exception e) {
                processedAll = false;
                logger.error(
                    "execute(): Error processing spreadsheet " +
                    spreadSheets.get(i),
                    e
                );
            }
        }

        // At the end of execution the parameter first_run is set to N, in the
        // next executions the system will only process spreadsheets from the
        // current year
        if (firstRun.equals("Y") && processedAll) {
            try {
                paramFirstRun.get().setValue("N");
                sysParametersDAO.save(paramFirstRun.get());
            } catch (Exception e) {
                logger.error("execute(): Error updating system parameter ", e);
            }
        }
    }
}
