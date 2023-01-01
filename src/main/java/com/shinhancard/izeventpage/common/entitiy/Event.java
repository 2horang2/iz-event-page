package com.shinhancard.izeventpage.common.entitiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long eventId;
    @Column(length = 30, nullable = false)
    private String name;
    @Column(length = 100, nullable = true)
    private String desc;
    @Column(length = 5, nullable = false)
    private int count = 0;
}
