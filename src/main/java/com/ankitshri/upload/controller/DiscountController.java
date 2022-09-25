package com.ankitshri.upload.controller;

import com.ankitshri.upload.entity.dto.CartDetailsDTO;
import com.ankitshri.upload.entity.dto.CartDiscountDTO;
import com.ankitshri.upload.service.CartDiscountDroolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//This controller is a practice for integration of drools rule engine with spring boot

@RestController
@RequestMapping("/api/v1")
public class DiscountController {

    @Autowired
    private CartDiscountDroolsService cartDiscountDroolsService;

    @PostMapping(value = "/get-discount")
    public ResponseEntity<CartDiscountDTO> getDiscountBasedOnCart(@RequestBody CartDetailsDTO cartDetailsDTO){
        CartDiscountDTO discount = cartDiscountDroolsService.getDiscount(cartDetailsDTO);
        return new ResponseEntity<>(discount, HttpStatus.OK);
    }
}
