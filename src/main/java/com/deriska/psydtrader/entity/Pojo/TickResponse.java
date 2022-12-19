package com.deriska.psydtrader.entity.Pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TickResponse {

    private EchoRequest echo_req;
    private String msg_type;
    private Subscription subscription;
    private Tick tick;

    public TickResponse(EchoRequest echo_req, String msg_type, Subscription subscription, Tick tick) {
        this.echo_req = echo_req;
        this.msg_type = msg_type;
        this.subscription = subscription;
        this.tick = tick;
    }

    public EchoRequest getEcho_req() {
        return echo_req;
    }

    public void setEcho_req(EchoRequest echo_req) {
        this.echo_req = echo_req;
    }

    public String getMsg_type() {
        return msg_type;
    }

    public void setMsg_type(String msg_type) {
        this.msg_type = msg_type;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public Tick getTick() {
        return tick;
    }

    public void setTick(Tick tick) {
        this.tick = tick;
    }

    @Override
    public String toString() {
        return "TickResponse{" +
                "echo_req=" + echo_req +
                ", msg_type='" + msg_type + '\'' +
                ", subscription=" + subscription +
                ", tick=" + tick +
                '}';
    }
}
