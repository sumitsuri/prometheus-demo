package com.example.actuatordemo.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import io.prometheus.client.Gauge;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class DemoMetrics {
//    private final Counter demoCounter;
    private final AtomicInteger demoGauge;
    private final AtomicInteger successRate;
    private final AtomicInteger threshold;
    private Gauge merchantSuccessRateGauge;

    public DemoMetrics(MeterRegistry meterRegistry) {
//        this.demoCounter = meterRegistry.counter("demo_counter");
        merchantSuccessRateGauge = Gauge.build().name("merchant_success_rate").help("Merchant success rate").labelNames("mid", "payment_code_group").register();
        this.demoGauge = meterRegistry.gauge("demo_gauge", new AtomicInteger(0));
        this.successRate = meterRegistry.gauge("success_rate", new AtomicInteger(0));
        this.threshold = meterRegistry.gauge("success_rate_threshold", new AtomicInteger(0));
    }

    public void pushMerchantSrRate(String mid, String paymentCodeGroup){
        merchantSuccessRateGauge.labels(mid, paymentCodeGroup).set(getRandomNumberInRange(0, 50));
    }


    public void updateSrThreshold() {
        int num = getRandomNumberInRange(0, 50);
        System.out.println("Num: " + num);
        demoGauge.set(num);
        successRate.set(num);
        threshold.set(60);
//        demoCounter.increment();
    }

    public static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}