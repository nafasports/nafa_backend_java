package com.deriska.psydtrader.service;

import com.deriska.psydtrader.entity.*;
import com.deriska.psydtrader.repository.ExitStrategyRepo;
import com.deriska.psydtrader.repository.RiskManagementRepo;
import com.deriska.psydtrader.repository.TradeJournalRepo;
import com.deriska.psydtrader.repository.TradingPlanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoTrader {

    @Autowired
    private RiskManagementRepo riskManagementRepo;
    @Autowired
    private TradeJournalRepo journalRepo;
    @Autowired
    private CalculationService calculationService;
    @Autowired
    private WatchListService watchListService;
    @Autowired
    private ExitStrategyRepo exitStrategyRepo;
    @Autowired
    private TradingPlanRepo tradingPlanRepo;


    public void executeStrictTrade(TradeRequest trade){

        Trades tradeJournal = new Trades(trade);

        TradeHolder tradeHolder = new TradeHolder();
        tradeHolder.setTradeId(journalRepo.save(tradeJournal).getId());

        RiskAnalysisResponse response = calculationService.calculateRiskAnalysis(trade);
        if(response.getPsychEvalScore() < 50){
            // Tell the user that we can't open the trade until he meets all his set criteria
        }else{
            // call the metatrader API to open the trade
        }
    }

    public void executeNonStrictTrade(TradeRequest tradeRequest){
        Trades tradeJournal = new Trades(tradeRequest);

        TradeHolder tradeHolder = new TradeHolder();
        tradeHolder.setTradeId(journalRepo.save(tradeJournal).getId());

        // Call a backgroundRunner here.
        RiskAnalysisResponse response = calculationService.calculateRiskAnalysis(tradeRequest);
        if(response.getPsychEvalScore() < 50){
            // Warn the trader of his error and suggest actions to take.
        }else{
            // call the metatrader API to open the trade
        }
    }

    public void setPriceAlertBasedOnTradeRequest(TradeRequest request){
        TradingPlan tradingPlan = tradingPlanRepo.findByPlanName(request.getTradingPlanName()).get();
        List<ExitStrategy> exitStrategies = exitStrategyRepo.findByTradingPlanId(tradingPlan.getPlanId());
        for(ExitStrategy ex : exitStrategies){
            double price = calculatePriceToSet(request, ex);
            SyntheticsAsset asset = new SyntheticsAsset();
            asset.setWatchPrice(price);
            asset.setActive(true);
            asset.setAlertMedium("Default Medium");
        }
    }

    private double calculatePriceToSet(TradeRequest request, ExitStrategy ex) {
        //Round to the symbols decimal places.
        double price  = Math.abs(request.getEntryPrice()/Math.floor(100/ex.getInTradeProfitLevel()));
        return price;
    }
}
