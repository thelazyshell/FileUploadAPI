package com.ankitshri.upload.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SampleTestJob {

    @Scheduled(fixedRate = 1000)
    public void execute(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        System.out.println("Hii This is a test and current time is "+sdf.format(new Date()));
    }
}
