package com.deriska.psydtrader.repository;

import com.deriska.psydtrader.entity.TradeChanges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TradeChangesRepo extends JpaRepository<TradeChanges, Long> {

    List<TradeChanges> findByTradeIdOrderByCreatedAtDesc(Long id);
}
