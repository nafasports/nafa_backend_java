package com.deriska.psydtrader.controller;

import com.deriska.psydtrader.entity.StandardResponse;
import com.deriska.psydtrader.entity.Trades;
import com.deriska.psydtrader.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class CalculateController {

    @Autowired
    private CalculationService calculationService;

    @PostMapping
    public ResponseEntity<StandardResponse> calculateTradeRisk(@RequestBody Trades trade){
        return calculationService.calculateTradeRisk(trade);
    }
}
