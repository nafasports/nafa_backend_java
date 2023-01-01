package com.deriska.psydtrader.entity.Pojo;

import lombok.RequiredArgsConstructor;

//Class that records the updates made by the changing conditions in the trade;

@RequiredArgsConstructor
public class TradeRecordUpdate {

    private String remarks;
    private Long tradingPlanId;


}
