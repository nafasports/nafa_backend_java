package com.deriska.psydtrader.repository;

import com.deriska.psydtrader.entity.TradeRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TradeRequestRepo extends JpaRepository<TradeRequest, Long> {
    Optional<TradeRequest> findByEntryPrice(double entryPrice);
}
