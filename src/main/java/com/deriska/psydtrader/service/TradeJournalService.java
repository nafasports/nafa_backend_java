package com.deriska.psydtrader.service;

import com.deriska.psydtrader.entity.Account;
import com.deriska.psydtrader.entity.Pojo.RunningTradeRequest;
import com.deriska.psydtrader.entity.Pojo.TradeRecordUpdate;
import com.deriska.psydtrader.entity.StandardResponse;
import com.deriska.psydtrader.entity.Trades;
import com.deriska.psydtrader.repository.TradeJournalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class TradeJournalService {

    @Autowired
    private TradeJournalRepo journalRepo;
    @Autowired
    private DerivService derivService;


    public ResponseEntity<StandardResponse> addTradeToJournal(Trades trade) {
        return null;
    }

    public ResponseEntity<StandardResponse> getAllRecordsFromJournal(Long journalId) {
        return null;
    }

    public ResponseEntity<StandardResponse> getRecordByTradeId(Long tradeId) {
        return null;
    }

    public ResponseEntity<StandardResponse> updateRecord(TradeRecordUpdate update, Long tradeId){
        return null;
    }

    public void updateRecordAfterClosedTraded(RunningTradeRequest request, Trades trades) {
        try {
            trades.setExitDate(request.getExitDate());
//            trades.setExitDate(LocalDateTime.now());
            trades.setClosingBalance(request.getAccountBalance());
            trades.setProfit(request.isInProfit());

            Account account = derivService.getAccountStatus(trades.getAccountId());
            trades.setClosingBalance(account.getAccountBalance());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
