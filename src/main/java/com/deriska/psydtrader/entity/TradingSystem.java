package com.deriska.psydtrader.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Data
public class TradingSystem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long systemId;
    private Long tradingPlanId;
    private Long journalId;
    private Long entryId;
    private Long exitId;
    @Transient
    private List<Analysis> systemAnalysis;
}
