package com.deriska.psydtrader.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class EntryStrategy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long entryId;
    @Transient
    private List<Analysis> entryAnalysis;
    private Long tradingPlanId;
    private String entryNote;
    private Long journalId;

}
