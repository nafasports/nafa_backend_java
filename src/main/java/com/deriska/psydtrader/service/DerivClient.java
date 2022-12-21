package com.deriska.psydtrader.service;

import com.deriska.psydtrader.entity.Pojo.DerivTickRequest;
import com.deriska.psydtrader.entity.Pojo.TickResponse;
import com.deriska.psydtrader.entity.StandardResponse;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.io.IOException;
import java.lang.InterruptedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.websocket.*;

@ClientEndpoint
@Service
public class DerivClient  {

    @Autowired
    private DerivService forwardService = new DerivService();

    private Session dsession;

    private final List<String> assets = Arrays.asList("R_10", "R_25");

    @OnOpen
    public void onOpen(Session session) throws java.io.IOException {
        this.dsession = session;
        Gson jsonTick = new Gson();
        DerivTickRequest request = new DerivTickRequest();

        for(String s : assets) {
            request.setTicks(s);
            session.getBasicRemote().sendText(jsonTick.toJson(request));
            System.out.println(jsonTick.toJson(request));
        }
    }

    @OnMessage
    public void onMessage(String message) throws DeploymentException, IOException, InterruptedException, JsonGenerationException, JsonMappingException {

        List<TickResponse> responses = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        TickResponse response = mapper.readValue(message, TickResponse.class);
        responses.add(response);
//         Gson jsonTick = new Gson();
        //   System.out.println(jsonTick.toJson(responses));
 
        forwardService.getFromDerivClient(responses);
    }

    public String closeSession() throws IOException{
        this.dsession.close();
        System.out.println("Websocket has been closed");
        return "Websocket has closed";
    }

    public static String makeConnection()
            throws IOException, DeploymentException, InterruptedException
    {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        URI apiUri = URI.create("wss://ws.binaryws.com/websockets/v3?app_id=1089");
        Session session = container.connectToServer(DerivClient.class, apiUri);
        while (session.isOpen()) {
            // receive ticks
        }
        return "Connection has been made";
    }

}