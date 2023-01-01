package com.deriska.psydtrader.service;

import com.deriska.psydtrader.entity.RiskAnalysisResponse;
import com.deriska.psydtrader.entity.TradeRequest;
import org.springframework.stereotype.Service;

@Service
public class CurrencyCalculatorService {

    public RiskAnalysisResponse calculateAll(TradeRequest trade) {
        RiskAnalysisResponse response = new RiskAnalysisResponse();
        return response;
    }
}
