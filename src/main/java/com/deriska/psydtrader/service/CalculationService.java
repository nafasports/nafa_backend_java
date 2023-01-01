package com.deriska.psydtrader.service;

import com.deriska.psydtrader.entity.*;
import com.deriska.psydtrader.repository.TradeJournalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {

    @Autowired
    private SyntheticCalculatorService syntheticCalculatorService;
    @Autowired
    private CurrencyCalculatorService currencyCalculatorService;
    @Autowired
    private TradeJournalRepo journalRepo;

    public ResponseEntity<StandardResponse> calculateTradeRisk(TradeRequest trade) {
        try {
            String category = trade.getAssetCategory();
            Trades tradeJournal = new Trades(trade);

            TradeHolder tradeHolder = new TradeHolder();
            tradeHolder.setTradeId(journalRepo.save(tradeJournal).getId());

            RiskAnalysisResponse response = new RiskAnalysisResponse();
            switch (category){
                case "Synthetics":
                    response = syntheticCalculatorService.calculateAll(trade);
                    break;
                case "Currencies":
                    response = currencyCalculatorService.calculateAll(trade);
            }
            return StandardResponse.sendHttpResponse(true, "Successful", response, "200");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Operation failed");
        }
    }
}
