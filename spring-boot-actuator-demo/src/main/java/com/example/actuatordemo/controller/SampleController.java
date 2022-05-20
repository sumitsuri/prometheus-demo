package com.example.actuatordemo.controller;

import com.example.actuatordemo.config.SalesforceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
public class SampleController {

//    @Autowired
//    private SalesforceConfig salesforceConfig;
//
//    @GetMapping("/test")
//    public String sayHello(@RequestParam(value = "name", defaultValue = "Guest") String name) {
//        System.out.println("Salesforceconfig: " + salesforceConfig);
//        System.out.println("Samplecontroller");
//        return "Hello " + name + "!!";
//    }

    @GetMapping("/slowApi")
    public String timeConsumingAPI(@RequestParam(value = "delay", defaultValue = "0") Integer delay) throws InterruptedException {
        if(delay == 0) {
            Random random = new Random();
            delay = random.nextInt(10);
        }

        TimeUnit.SECONDS.sleep(delay);
        return "Result";
    }

}
