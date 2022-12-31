package com.shinhancard.izeventpage.common.entitiy;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @Column(length = 30, nullable = false)
    String name;
    @Column(length = 4, nullable = true)
    String hdp1;
    @Column(length = 4, nullable = true)
    String hdp2;
    @Column(length = 4, nullable = true)
    String hdp3;
    @Column
    LocalDateTime niRgDt;

    @OneToOne
    @JoinColumn(name = "eventId")
    Event event;

}
