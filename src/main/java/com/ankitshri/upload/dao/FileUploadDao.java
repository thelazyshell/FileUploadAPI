package com.ankitshri.upload.dao;

import com.ankitshri.upload.entity.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FileUploadDao extends JpaRepository<ProductModel, Long> {
}
