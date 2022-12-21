package com.deriska.psydtrader.service;

import com.deriska.psydtrader.entity.Pojo.TickResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DerivService {


    public void getFromDerivClient(List<TickResponse> responses){

        PriceAlertService alertService = new PriceAlertService();
        double price = 0;
        for(TickResponse res : responses){
            price = res.getTick().getQuote();
            alertService.checkSyntheticPrice(price);
            // System.out.println(price); 
        }
    }


}
