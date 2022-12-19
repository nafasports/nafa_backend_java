package com.deriska.psydtrader.entity;

import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@RequiredArgsConstructor
public class Analysis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String analysisName;

    @ManyToMany(mappedBy = "listOfAnalysis")
    private List<Trades> tradesList;

}
