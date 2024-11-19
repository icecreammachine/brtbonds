package com.icecreammachine.brtbonds.processing;

import com.icecreammachine.brtbonds.dao.BondHistoryDataDAO;
import com.icecreammachine.brtbonds.dao.IssuedBondDAO;
import com.icecreammachine.brtbonds.entity.BondHistoryData;
import com.icecreammachine.brtbonds.entity.BondType;
import com.icecreammachine.brtbonds.entity.IssuedBond;
import com.icecreammachine.brtbonds.utils.DateUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessExcelFile {

    private static final Logger logger = LoggerFactory.getLogger(
        ProcessExcelFile.class
    );

    @Autowired
    private IssuedBondDAO issuedBondDAO;

    @Autowired
    private BondHistoryDataDAO bondHistoryDataDAO;

    /**
     * Process the data from the historic spreadsheets
     *
     * @param file
     * @param bondType
     * @throws IOException
     */
    public void processHistoricSpreadsheet(String file, BondType bondType)
        throws Exception {
        Workbook workbook = null;
        final BigDecimal ONE_HUNDRED = new BigDecimal("100");

        try {
            File spreadsheet = new File(file);

            workbook = WorkbookFactory.create(
                new FileInputStream(spreadsheet.getCanonicalPath())
            );

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                "dd/MM/yyyy"
            );

            logger.info(
                "processHistoricSpreadsheet(): Processing file: " +
                spreadsheet.getName()
            );

            // PROCESSING spreadsheet
            // Process all sheets
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                Sheet sheet = workbook.getSheetAt(i);

                // Data de vencimento
                Cell cellVencimento = sheet.getRow(0).getCell(1);

                logger.info(
                    "processHistoricSpreadsheet(): Processing spreadsheet: " +
                    sheet.getSheetName()
                );
                // System.out.println(sheet.getRow(0).getCell(0) + " at row=0
                // col=0");
                // System.out.println(sheet.getRow(0).getCell(1) + " at row=0
                // col=1");

                LocalDate maturityDate = LocalDate.parse(
                    getCellValue(workbook, cellVencimento),
                    formatter
                );

                // Codigo de emissao do titulo (Sigla + Data de vencimento)
                String issuedBondCode =
                    bondType.getSmallDesc() +
                    " " +
                    maturityDate.format(DateTimeFormatter.ofPattern("ddMMyy"));

                // Check if bond exits (registro do titulo)
                IssuedBond issuedBond = issuedBondDAO.findByCode(
                    issuedBondCode
                );

                if (issuedBond == null) {
                    try {
                        issuedBond = new IssuedBond();
                        issuedBond.setBondType(bondType);
                        issuedBond.setMaturityDate(
                            DateUtils.asDate(maturityDate)
                        );
                        issuedBond.setCode(issuedBondCode);
                        issuedBond = issuedBondDAO.save(issuedBond);
                    } catch (Exception ex) {
                        logger.error(
                            "processHistoricSpreadsheet(): Error processing issued bond"
                        );
                        throw ex;
                    }
                }

                // PROCESSING LINES
                try {
                    // Start from line 3
                    for (
                        int rowNum = 2;
                        rowNum < sheet.getPhysicalNumberOfRows();
                        rowNum++
                    ) {
                        Row row = sheet.getRow(rowNum);
                        if (!row.getZeroHeight()) {
                            Cell cellDataHist = row.getCell(0);
                            Cell cellTxCompra = row.getCell(1);
                            Cell cellTxVenda = row.getCell(2);
                            Cell cellPUCompra = row.getCell(3);
                            Cell cellPUVenda = row.getCell(4);
                            Cell cellPUBase = row.getCell(5);

                            // PROCESSING COLUMNS
                            // for (int colNum = row.getFirstCellNum(); colNum <
                            // row.getLastCellNum(); colNum++)
                            // {
                            // if (row.getCell(colNum) != null)
                            // {
                            // System.out.println(getCellValue(workbook,
                            // row.getCell(colNum)) + " at row=" +
                            // rowNum
                            // + " col=" + colNum);
                            // }
                            // }

                            // if taxa de compra is null discard line
                            if (
                                cellDataHist != null &&
                                cellTxCompra != null &&
                                cellTxVenda != null &&
                                cellPUCompra != null &&
                                cellPUVenda != null
                            ) {
                                String cellValueDataHist = getCellValue(
                                    workbook,
                                    cellDataHist
                                );
                                String cellValueTxCompra = getCellValue(
                                    workbook,
                                    cellTxCompra
                                );
                                String cellValueTxVenda = getCellValue(
                                    workbook,
                                    cellTxVenda
                                );
                                String cellValuePUCompra = getCellValue(
                                    workbook,
                                    cellPUCompra
                                );
                                String cellValuePUVenda = getCellValue(
                                    workbook,
                                    cellPUVenda
                                );

                                // Cell is not null but content is empty
                                // Check db if line is there, searcn by titulo emitido (Codigo + Data historico)
                                if (
                                    cellValueDataHist.equals("") ||
                                    cellValueTxCompra.equals("") ||
                                    bondHistoryDataDAO.findByIssuedBondHistDate(
                                        issuedBondCode,
                                        DateUtils.asDate(
                                            LocalDate.parse(
                                                cellValueDataHist,
                                                formatter
                                            )
                                        )
                                    ) !=
                                    null
                                ) {
                                    break;
                                }

                                BondHistoryData bondHistory =
                                    new BondHistoryData();
                                bondHistory.setIssuedBond(issuedBond);

                                // Data histórico
                                LocalDate dia = LocalDate.parse(
                                    getCellValue(workbook, cellDataHist),
                                    formatter
                                );
                                bondHistory.setHistDate(DateUtils.asDate(dia));

                                // Taxa compra
                                bondHistory.setRateBuy(
                                    new BigDecimal(cellValueTxCompra).multiply(
                                        ONE_HUNDRED
                                    )
                                );

                                // Taxa venda
                                bondHistory.setRateSell(
                                    new BigDecimal(cellValueTxVenda).multiply(
                                        ONE_HUNDRED
                                    )
                                );

                                // PU compra
                                bondHistory.setPuBuy(
                                    new BigDecimal(cellValuePUCompra).setScale(
                                        2,
                                        RoundingMode.HALF_UP
                                    )
                                );

                                // PU venda
                                bondHistory.setPuSell(
                                    new BigDecimal(cellValuePUVenda).setScale(
                                        2,
                                        RoundingMode.HALF_UP
                                    )
                                );

                                // PU base
                                if (cellPUBase != null) {
                                    String cellValuePUBase = getCellValue(
                                        workbook,
                                        cellPUBase
                                    );
                                    if (!cellValuePUBase.equals("")) {
                                        bondHistory.setPuBase(
                                            new BigDecimal(
                                                cellValuePUBase
                                            ).setScale(2, RoundingMode.HALF_UP)
                                        );
                                    }
                                }

                                // Save history
                                bondHistoryDataDAO.save(bondHistory);
                            }
                        }
                    }
                } catch (Exception ex) {
                    logger.error(
                        "processHistoricSpreadsheet(): Error processing history data"
                    );
                    throw ex;
                }
            }

            workbook.close();
        } catch (Exception ex) {
            if (workbook != null) {
                workbook.close();
            }

            throw ex;
        }
    }

    /**
     * Returns cell value according to its type
     *
     * @param workbook
     * @param cell
     * @return
     */
    private static String getCellValue(Workbook workbook, Cell cell) {
        FormulaEvaluator evaluator = workbook
            .getCreationHelper()
            .createFormulaEvaluator();

        CellType cellType = cell.getCellType();

        if (cell.getCellType() == CellType.FORMULA) {
            CellValue cellValue = evaluator.evaluate(cell);
            cellType = cellValue.getCellType();
        }

        switch (cellType) {
            case BOOLEAN:
                return Boolean.toString(cell.getBooleanCellValue());
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return new SimpleDateFormat("dd/MM/yyyy").format(
                        cell.getDateCellValue()
                    );
                } else {
                    return (
                        Double.valueOf(
                            cell.getNumericCellValue()
                        ).doubleValue() +
                        ""
                    );
                }
            case STRING:
                return cell.getStringCellValue();
            case BLANK:
                return "";
            case FORMULA:
            default:
                return "Not Expected";
        }
    }
}
