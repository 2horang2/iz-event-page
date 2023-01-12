package com.shinhancard.izeventpage.common.entitiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table
@Data
@AllArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(length = 30, nullable = false)
    private String name;
    @Column(length = 60, nullable = true)
    private String detail;
    @Column(length = 5, nullable = false)
    private int count = 0;

    public void increaseCount() {
        this.count++;
    }
}
