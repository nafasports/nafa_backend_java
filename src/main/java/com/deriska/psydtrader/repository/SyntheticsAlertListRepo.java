package com.deriska.psydtrader.repository;

import com.deriska.psydtrader.entity.SyntheticsAsset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SyntheticsAlertListRepo extends JpaRepository<SyntheticsAsset, Long> {
}
