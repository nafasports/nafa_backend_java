package com.deriska.psydtrader.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@RequiredArgsConstructor
@Data
public class TradeSummary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long summaryId;
    private double stopLossChange;
    private Long tradeId;
    private int numberOfChanges;
    private double lotSizeChange;
    private double takeProfitChange;
    private double percentageLoss;
    private double percentageProfit;
    private double riskRewardRatio;
    private double amountProfit;
    private double amountLoss;
    private boolean isPositive;
    private boolean isActive;
    private String remarks;

}
