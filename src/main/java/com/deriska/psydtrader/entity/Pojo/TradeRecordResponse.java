package com.deriska.psydtrader.entity.Pojo;

import com.deriska.psydtrader.entity.TradeChanges;
import com.deriska.psydtrader.entity.Trades;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
public class TradeRecordResponse {

    private Long id;
    private Trades tradeRecord;
    private List<TradeChanges> changesList;

    public TradeRecordResponse(Trades tradeRecord, List<TradeChanges> changesList){
        this.tradeRecord = tradeRecord;
        this.changesList =changesList;
    }
}
