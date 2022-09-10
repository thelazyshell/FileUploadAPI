package com.ankitshri.upload.job;

import com.ankitshri.upload.entity.model.ProductModel;
import com.ankitshri.upload.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

//This job is defined to print the product details every 10 seconds from DB

@Component
public class ProductDetailsJob {


    @Autowired
    private FileUploadService uploadService;


    @Scheduled(fixedRate = 10000)
    public void execute(){
        List<ProductModel> entriesFromDB = this.uploadService.getEntriesFromDB();
        System.out.println(entriesFromDB.toString());
    }
}
