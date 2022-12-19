package com.deriska.psydtrader.service;

import com.deriska.psydtrader.entity.StandardResponse;
import com.deriska.psydtrader.entity.Trades;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {
    public ResponseEntity<StandardResponse> calculateTradeRisk(Trades trade) {
        try{
            return null;
        }catch (Exception e){
            return null;
        }
    }

    public double calculateRiskRewardRatio(){
        double x = 000;
        return x;
    }
}
