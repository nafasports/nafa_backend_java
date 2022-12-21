package com.deriska.psydtrader.repository;

import com.deriska.psydtrader.entity.SyntheticsAlertList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SyntheticsAlertListRepo extends JpaRepository<SyntheticsAlertList, Long> {
}
