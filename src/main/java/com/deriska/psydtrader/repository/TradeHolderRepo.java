package com.deriska.psydtrader.repository;


import com.deriska.psydtrader.entity.TradeHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TradeHolderRepo extends JpaRepository<TradeHolder, Long> {
    Optional<TradeHolder> findByTradeId(Long id);

    Optional<TradeHolder> findTopByTradeIdOrderByCreatedDateDesc(Long tradeId);
}
