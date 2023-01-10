package com.jovine.nafa.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@RequiredArgsConstructor
@Data
public class Fixtures {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fixtureId;
    private String fixName;
    private LocalDateTime fixtureDate;

}
