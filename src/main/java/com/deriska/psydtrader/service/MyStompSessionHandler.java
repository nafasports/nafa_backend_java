package com.deriska.psydtrader.service;

import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;

import java.lang.reflect.Type;

public class MyStompSessionHandler implements StompSessionHandler {

    private Logger logger = (Logger) LogManager.getLogger(MyStompSessionHandler.class);


    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {

        logger.info("New session established : " + session.getSessionId());
        session.subscribe("/topic/messages", this);
        logger.info("Subscribed to /topic/messages");

//        session.send("/app/chat", getSampleMessage());
//        logger.info("Message sent to websocket server");
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        logger.error("Got an exception", exception);
    }

    @Override
    public void handleTransportError(StompSession session, Throwable exception) {

    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return null;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {

    }

//    private Message getSampleMessage() {
//        Message msg = new Message();
//        msg.setFrom("Nicky");
//        msg.setText("Howdy!!");
//        return msg;
//    }
}
