package com.deriska.psydtrader.entity.Pojo;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DerivTickRequest {

    private String ticks;
    private List<String> tickList;


    public String getTicks() {
        return ticks;
    }

    public void setTicks(String tick) {
        this.ticks = tick;
    }
}
