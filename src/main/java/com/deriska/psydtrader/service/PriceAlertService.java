package com.deriska.psydtrader.service;

import com.deriska.psydtrader.entity.SyntheticsAlertList;
import com.deriska.psydtrader.repository.SyntheticsAlertListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceAlertService {
    @Autowired
    private SyntheticsAlertListRepo watchListRepo;

    private final String UP = "UP";
    private final String DOWN = "DOWN";

    public void checkSyntheticPrice(double currentPrice){
        try {
            List<SyntheticsAlertList> watchList = watchListRepo.findAll();
            String message = "I am confused";
            for(SyntheticsAlertList watch : watchList){
                double priceWatch = watch.getWatchPrice();
                if(watch.getPosition().equalsIgnoreCase(DOWN)) {
                    if (priceWatch < currentPrice) {
                        message = "Price just went below " + priceWatch + ".";
//                        System.out.println(message);
                    }
                }else{
                    if(priceWatch > currentPrice){
                        message = "Price just went below " + priceWatch + ".";
//                        System.out.print(message);
                    }
                }
            }
            // System.out.println(message);

        } catch (Exception e) {
            System.out.println(e.getCause()); 
        }
    }
}
