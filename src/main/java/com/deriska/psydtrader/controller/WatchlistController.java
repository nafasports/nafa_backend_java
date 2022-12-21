package com.deriska.psydtrader.controller;

import com.deriska.psydtrader.entity.StandardResponse;
import com.deriska.psydtrader.entity.SyntheticsAlertList;
import com.deriska.psydtrader.repository.SyntheticsAlertListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/watchlist")
public class WatchlistController {

    @Autowired
    private SyntheticsAlertListRepo watchListRepo;

    @PostMapping("/addtoalertlist")
    public ResponseEntity<StandardResponse> addToAlertList(@RequestBody SyntheticsAlertList watch) {
        try {
            return StandardResponse.sendHttpResponse(true, "Added to list", watchListRepo.save(watch), "200");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not add to alert List");
        }
    }

    @GetMapping("/getwatchedprices")
    public ResponseEntity<StandardResponse> getAllWatchPrice(){
        try {
            return StandardResponse.sendHttpResponse(true, "Added to list", watchListRepo.findAll(), "200");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not add to alert List");
        }
    }
}
