package com.deriska.psydtrader.entity.Pojo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EchoRequest {

    private int subscribe;
    private String ticks;

    public EchoRequest(int subscribe, String ticks) {
        this.subscribe = subscribe;
        this.ticks = ticks;
    }

    public int getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(int subscribe) {
        this.subscribe = subscribe;
    }

    public String getTicks() {
        return ticks;
    }

    public void setTicks(String ticks) {
        this.ticks = ticks;
    }
}
