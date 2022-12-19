package com.deriska.psydtrader.controller;

import com.deriska.psydtrader.entity.StandardResponse;
import com.deriska.psydtrader.service.DerivClient;
import com.deriska.psydtrader.service.DerivService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.DeploymentException;
import java.io.IOException;

@RestController
@RequestMapping("/synthetics")
public class SyntheticPriceController {

    @Autowired
    private DerivClient derivClient;

    @Autowired
    private DerivService derivService;



    @GetMapping("/connect")
    public String makeConnection() throws DeploymentException, IOException, InterruptedException {
        derivClient.makeConnection();
        return "Connection has been made";
    }

    @GetMapping("/getprices")
    public ResponseEntity<StandardResponse> getPriceList(){
        return derivService.forwardToClient();
    }
}
