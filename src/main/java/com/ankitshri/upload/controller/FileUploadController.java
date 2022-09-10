package com.ankitshri.upload.controller;

import com.ankitshri.upload.service.FileUploadService;
import com.ankitshri.upload.utils.UploadValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class FileUploadController {
    /* Implement some kind of cronjob as well in this project*/
    @Autowired
    private FileUploadService uploadService;
    @Autowired
    private UploadValidator validator;

    @PostMapping("/excel/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file){
        if (validator.checkExcelFormat(file)) {
            uploadService.saveEntries(file);
            return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to db"));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file only");
    }
}
