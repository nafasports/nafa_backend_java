package com.deriska.psydtrader.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class TradingPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planId;
    private String planName;
    private String planOutline;
    private Long tradeId;
    private Long accountId;
    private String planOwner;
    @Transient
    private List<Analysis> strategyAnalysis;
    private String analysisNote;
    private Long tradingSystemId;
    private Long riskMgtId;
    private String traderType; //(Day trader, swing trader etc...)
    private Long exitId;

}
