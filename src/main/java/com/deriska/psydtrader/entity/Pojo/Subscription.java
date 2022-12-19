package com.deriska.psydtrader.entity.Pojo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Subscription {

    private String id;

    public Subscription(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
