package com.deriska.psydtrader.repository;

import com.deriska.psydtrader.entity.TradingPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TradingPlanRepo extends JpaRepository<TradingPlan, Long> {
    Optional<TradingPlan> findByTradeId(Long id);

    Optional<TradingPlan> findByPlanName(String tradingPlanName);
}
