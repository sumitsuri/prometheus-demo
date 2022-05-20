package com.example.actuatordemo.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DemoMetricsScheduler {

    private final DemoMetrics demoMetrics;

    public DemoMetricsScheduler(DemoMetrics demoMetrics) {
        this.demoMetrics = demoMetrics;
    }

    @Scheduled(fixedRate = 30000)
    public void triggerCustomMetrics() {
        System.out.println("Executing at: " + new Date());
        //demoMetrics.getRandomMetricsData();
        String[] mids = {"1","2","3"};
        String[] paymentCodeGroups = {"visa","debit","mastercard"};
        int randomNum = DemoMetrics.getRandomNumberInRange(0,2);
        demoMetrics.pushMerchantSrRate(mids[randomNum], paymentCodeGroups[randomNum]);
    }
}
