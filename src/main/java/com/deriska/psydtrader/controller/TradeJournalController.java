package com.deriska.psydtrader.controller;

import com.deriska.psydtrader.entity.Pojo.TradeRecordUpdate;
import com.deriska.psydtrader.entity.StandardResponse;
import com.deriska.psydtrader.entity.Trades;
import com.deriska.psydtrader.service.TradeJournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tradejournal")
public class TradeJournalController {

    @Autowired
    private TradeJournalService journalService;
    @PostMapping("/addrecordtojournal")
    public ResponseEntity<StandardResponse> addTradeToJournal(@RequestBody Trades trade){
        return journalService.addTradeToJournal(trade);
    }

    @GetMapping("/getallrecordsfromjournal")
    public ResponseEntity<StandardResponse> getAllTradesFromJournal(@RequestParam("journalId") Long journalId){
        return journalService.getAllRecordsFromJournal(journalId);
    }

    @GetMapping("/getrecordbytradeid")
    public ResponseEntity<StandardResponse> getRecordByTradeId(@RequestParam("tradeId") Long tradeId){
        return journalService.getRecordByTradeId(tradeId);
    }

    @PutMapping("/updaterecord")
    public ResponseEntity<StandardResponse> updateRecord(@RequestBody TradeRecordUpdate update, @RequestParam("tradeId") Long tradeId){
        return journalService.updateRecord(update, tradeId);
    }
}
