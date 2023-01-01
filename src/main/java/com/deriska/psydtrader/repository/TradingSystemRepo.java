package com.deriska.psydtrader.repository;

import com.deriska.psydtrader.entity.TradingSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TradingSystemRepo extends JpaRepository<TradingSystem, Long> {

    Optional<TradingSystem> findByTradingPlanId(Long planId);
}
