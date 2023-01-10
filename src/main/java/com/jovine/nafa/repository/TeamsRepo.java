package com.jovine.nafa.repository;

import com.jovine.nafa.entity.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamsRepo extends JpaRepository<Teams, Long> {
    List<Teams> findByLeagueId(Long leagueId);
}
