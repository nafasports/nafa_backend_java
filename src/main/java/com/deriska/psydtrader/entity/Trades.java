package com.deriska.psydtrader.entity;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@RequiredArgsConstructor
public class Trades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String asset;
    private double openPrice;
    private String tradeType;
    private double stopLoss;
    private double takeProfit;
    private double lotSize;
    private double pipsProfit;
    private double pipsLoss;
    private double riskRewardRatio;
    private double percentageProfit;
    private double amountProfit;
    private double amountLoss;
    private double percentageLoss;
    private String profitability;
    private String accountId;
    private double accountChange;
    private double tradeScore;
    private boolean status;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime entryDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime exitDate;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "TRADE_ANALYSIS",
            joinColumns = {
                    @JoinColumn(name = "TRADE_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ANALYSIS_ID")
            }
    )
    private List<Analysis> listOfAnalysis;

    public Trades(Long id, String asset, double openPrice, String tradeType, double stopLoss, double takeProfit, double lotSize,
                  double pipsProfit, double pipsLoss, double riskRewardRatio, double percentageProfit, double amountProfit,
                  double amountLoss, double percentageLoss, String profitability, String accountId, double accountChange, double tradeScore,
                  boolean status, LocalDateTime entryDate, LocalDateTime exitDate, List<Analysis> listOfAnalysis) {
        this.id = id;
        this.asset = asset;
        this.openPrice = openPrice;
        this.tradeType = tradeType;
        this.stopLoss = stopLoss;
        this.takeProfit = takeProfit;
        this.lotSize = lotSize;
        this.pipsProfit = pipsProfit;
        this.pipsLoss = pipsLoss;
        this.riskRewardRatio = riskRewardRatio;
        this.percentageProfit = percentageProfit;
        this.amountProfit = amountProfit;
        this.amountLoss = amountLoss;
        this.percentageLoss = percentageLoss;
        this.profitability = profitability;
        this.accountId = accountId;
        this.accountChange = accountChange;
        this.tradeScore = tradeScore;
        this.status = status;
        this.entryDate = entryDate;
        this.exitDate = exitDate;
        this.listOfAnalysis = listOfAnalysis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(double openPrice) {
        this.openPrice = openPrice;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public double getStopLoss() {
        return stopLoss;
    }

    public void setStopLoss(double stopLoss) {
        this.stopLoss = stopLoss;
    }

    public double getTakeProfit() {
        return takeProfit;
    }

    public void setTakeProfit(double takeProfit) {
        this.takeProfit = takeProfit;
    }

    public double getLotSize() {
        return lotSize;
    }

    public void setLotSize(double lotSize) {
        this.lotSize = lotSize;
    }

    public double getPipsProfit() {
        return pipsProfit;
    }

    public void setPipsProfit(double pipsProfit) {
        this.pipsProfit = pipsProfit;
    }

    public double getPipsLoss() {
        return pipsLoss;
    }

    public void setPipsLoss(double pipsLoss) {
        this.pipsLoss = pipsLoss;
    }

    public double getRiskRewardRatio() {
        return riskRewardRatio;
    }

    public void setRiskRewardRatio(double riskRewardRatio) {
        this.riskRewardRatio = riskRewardRatio;
    }

    public double getPercentageProfit() {
        return percentageProfit;
    }

    public void setPercentageProfit(double percentageProfit) {
        this.percentageProfit = percentageProfit;
    }

    public double getAmountProfit() {
        return amountProfit;
    }

    public void setAmountProfit(double amountProfit) {
        this.amountProfit = amountProfit;
    }

    public double getAmountLoss() {
        return amountLoss;
    }

    public void setAmountLoss(double amountLoss) {
        this.amountLoss = amountLoss;
    }

    public double getPercentageLoss() {
        return percentageLoss;
    }

    public void setPercentageLoss(double percentageLoss) {
        this.percentageLoss = percentageLoss;
    }

    public String getProfitability() {
        return profitability;
    }

    public void setProfitability(String profitability) {
        this.profitability = profitability;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getAccountChange() {
        return accountChange;
    }

    public void setAccountChange(double accountChange) {
        this.accountChange = accountChange;
    }

    public double getTradeScore() {
        return tradeScore;
    }

    public void setTradeScore(double tradeScore) {
        this.tradeScore = tradeScore;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }

    public LocalDateTime getExitDate() {
        return exitDate;
    }

    public void setExitDate(LocalDateTime exitDate) {
        this.exitDate = exitDate;
    }

    public List<Analysis> getListOfAnalysis() {
        return listOfAnalysis;
    }

    public void setListOfAnalysis(List<Analysis> listOfAnalysis) {
        this.listOfAnalysis = listOfAnalysis;
    }

    @Override
    public String toString() {
        return "Trades{" +
                "id=" + id +
                ", asset='" + asset + '\'' +
                ", openPrice=" + openPrice +
                ", tradeType='" + tradeType + '\'' +
                ", stopLoss=" + stopLoss +
                ", takeProfit=" + takeProfit +
                ", lotSize=" + lotSize +
                ", pipsProfit=" + pipsProfit +
                ", pipsLoss=" + pipsLoss +
                ", riskRewardRatio=" + riskRewardRatio +
                ", percentageProfit=" + percentageProfit +
                ", amountProfit=" + amountProfit +
                ", amountLoss=" + amountLoss +
                ", percentageLoss=" + percentageLoss +
                ", profitability='" + profitability + '\'' +
                ", accountId='" + accountId + '\'' +
                ", accountChange=" + accountChange +
                ", tradeScore=" + tradeScore +
                ", status=" + status +
                ", entryDate=" + entryDate +
                ", exitDate=" + exitDate +
                ", listOfAnalysis=" + listOfAnalysis +
                '}';
    }
}
