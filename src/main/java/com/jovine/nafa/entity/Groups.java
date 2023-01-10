package com.jovine.nafa.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@RequiredArgsConstructor
@Data
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long groupId;
    private String groupName;
    private int groupNumber;
}
