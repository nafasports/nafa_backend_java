package com.deriska.psydtrader.repository;

import com.deriska.psydtrader.entity.ExitStrategy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExitStrategyRepo extends JpaRepository<ExitStrategy, Long> {

    List<ExitStrategy> findByTradingPlanId(Long tradingId);

    Optional<ExitStrategy> findByTradingPlanIdAndCount(Long planId, int count);
}
