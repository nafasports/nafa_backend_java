package com.deriska.psydtrader.entity.Pojo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PriceProposalRequest {

    private int proposal;
    private int amount;
    private String barrier;
    private String basis;
    private String contract_type;
    private String currency;

    private int duration;
    private String duration_unit;
    private String symbol;

    public PriceProposalRequest(int proposal, int amount, String barrier, String basis,
                                String contract_type, String currency, String duration_unit, int duration, String symbol) {
        this.proposal = proposal;
        this.amount = amount;
        this.barrier = barrier;
        this.basis = basis;
        this.contract_type = contract_type;
        this.currency = currency;
        this.duration = duration;
        this.duration_unit = duration_unit;
        this.symbol = symbol;
    }

}
