package com.ankitshri.upload.service;

import com.ankitshri.upload.dao.FileUploadDao;
import com.ankitshri.upload.entity.model.ProductModel;
import com.ankitshri.upload.utils.UploadValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class FileUploadService {

    @Autowired
    private FileUploadDao fileUploadDao;
    @Autowired
    private UploadValidator validator;

    //save the values to DB
    public void saveEntries(MultipartFile file){
        try {
            List<ProductModel> products = validator.convertExcelToListOfProduct(file.getInputStream());
            this.fileUploadDao.saveAll(products);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    //fetch the values from DB
    public List<ProductModel> getEntriesFromDB(){
        try {
            return this.fileUploadDao.findAll();
        }
        catch (Exception e){
            throw new EntityNotFoundException();
        }
    }
}
