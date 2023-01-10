package com.jovine.nafa.service;

import com.jovine.nafa.repository.StandingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StandingService {
    @Autowired
    private StandingRepo standingRepo;
}
