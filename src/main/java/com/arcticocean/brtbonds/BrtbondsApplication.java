package com.icecreammachine.brtbonds;

import com.icecreammachine.brtbonds.job.JobDownloadHistoricalPricesRates;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BrtbondsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(
            BrtbondsApplication.class,
            args
        );

        context.getBean(JobDownloadHistoricalPricesRates.class).execute();
    }
}
