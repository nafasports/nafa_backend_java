package com.deriska.psydtrader.controller;

import com.deriska.psydtrader.entity.StandardResponse;
import com.deriska.psydtrader.entity.SyntheticsAsset;
import com.deriska.psydtrader.service.WatchListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/watchlist")
public class WatchListController {

    @Autowired
    private WatchListService watchListService;

    @PostMapping("/addtowatchlist")
    public ResponseEntity<StandardResponse> addSyntheticPriceToList(@RequestBody SyntheticsAsset asset){
        return watchListService.addSyntheicPriceToWatchList(asset);
    }

    @GetMapping("/getsyntheticsassetlist")
    public ResponseEntity<StandardResponse> getAllAssetsFromList(){
        return watchListService.getAllAssetsFromList();
    }

}
