package com.deriska.psydtrader.service;

import com.deriska.psydtrader.entity.StandardResponse;
import com.deriska.psydtrader.entity.SyntheticsAsset;
import com.deriska.psydtrader.repository.SyntheticsAlertListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WatchListService {

    @Autowired
    private SyntheticsAlertListRepo alertListRepo;

    public ResponseEntity<StandardResponse> addSyntheicPriceToWatchList(SyntheticsAsset asset) {
        try {
            return StandardResponse.sendHttpResponse(true, "Successful", alertListRepo.save(asset), "200");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Operation failed");
        }
    }

    public ResponseEntity<StandardResponse> getAllAssetsFromList() {
        try {
            return StandardResponse.sendHttpResponse(true, "Successful", alertListRepo.findAll(), "200");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Operation failed");
        }
    }
}
