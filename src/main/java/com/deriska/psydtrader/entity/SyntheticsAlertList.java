package com.deriska.psydtrader.entity;

import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@RequiredArgsConstructor
public class SyntheticsAlertList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String watchId;
    private Long accountId;
    private String symbol;
    private double watchPrice;
    private String position;
    private String alertMedium;
    private boolean isActive;

    private String remark;

    public SyntheticsAlertList(Long id, String watchId, String symbol,Long accountId, String remark,
                        double watchPrice, String position, boolean isActive,String alertMedium) {
        this.id = id;
        this.alertMedium = alertMedium;
        this.isActive = isActive;
        this.watchId = watchId;
        this.remark = remark;
        this.symbol = symbol;
        this.accountId = accountId;
        this.watchPrice = watchPrice;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWatchId() {
        return watchId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getAlertMedium() {
        return alertMedium;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public void setAlertMedium(String alertMedium) {
        this.alertMedium = alertMedium;
    }

    public void setWatchId(String watchId) {
        this.watchId = watchId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getWatchPrice() {
        return watchPrice;
    }

    public void setWatchPrice(double watchPrice) {
        this.watchPrice = watchPrice;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
