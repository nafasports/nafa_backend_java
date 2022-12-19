package com.deriska.psydtrader.service;

import com.deriska.psydtrader.entity.Pojo.TickResponse;
import com.deriska.psydtrader.entity.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DerivService {

    private List<TickResponse> tickResponse;

    public void getFromDerivClient(List<TickResponse> responses){
        this.tickResponse = responses;
        System.out.println(tickResponse.toString());
    }

    public ResponseEntity<StandardResponse> forwardToClient() {
        try {
            return StandardResponse.sendHttpResponse(true, "Successful", tickResponse, "200");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Failed");
        }
    }
}
