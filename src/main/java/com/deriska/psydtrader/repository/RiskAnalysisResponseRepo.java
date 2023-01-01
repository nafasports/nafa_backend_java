package com.deriska.psydtrader.repository;

import com.deriska.psydtrader.entity.RiskAnalysisResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RiskAnalysisResponseRepo extends JpaRepository<RiskAnalysisResponse, Long> {
    Optional<RiskAnalysisResponse> findByTradeId(Long id);
}
