package com.ankitshri.upload.service;

import com.ankitshri.upload.entity.dto.CartDetailsDTO;
import com.ankitshri.upload.entity.dto.CartDiscountDTO;
import org.drools.core.beliefsystem.abductive.Abducible;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CartDiscountDroolsService {

    @Autowired
    private KieContainer kieContainer;

    public CartDiscountDTO getDiscount(CartDetailsDTO orderRequest) {
        CartDiscountDTO cartDiscount = new CartDiscountDTO();
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("cartDiscount", cartDiscount);
        kieSession.insert(orderRequest);
        kieSession.fireAllRules();
        kieSession.dispose();
        if(cartDiscount.getDiscountPercent() != null){
            cartDiscount.setDiscountValue((cartDiscount.getDiscountPercent()*orderRequest.getCartValue())/100);
        }
        return cartDiscount;
    }
}
