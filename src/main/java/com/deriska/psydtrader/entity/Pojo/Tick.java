package com.deriska.psydtrader.entity.Pojo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Tick {

    private double ask;
    private double bid;
    private Long epoch;
    private String id;
    private int pip_size;
    private double quote;
    private String symbol;

    public Tick(double ask, double bid, Long epoch, String id, int pip_size, double quote, String symbol) {
        this.ask = ask;
        this.bid = bid;
        this.epoch = epoch;
        this.id = id;
        this.pip_size = pip_size;
        this.quote = quote;
        this.symbol = symbol;
    }

    public double getAsk() {
        return ask;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public Long getEpoch() {
        return epoch;
    }

    public void setEpoch(Long epoch) {
        this.epoch = epoch;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPip_size() {
        return pip_size;
    }

    public void setPip_size(int pip_size) {
        this.pip_size = pip_size;
    }

    public double getQuote() {
        return quote;
    }

    public void setQuote(double quote) {
        this.quote = quote;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
