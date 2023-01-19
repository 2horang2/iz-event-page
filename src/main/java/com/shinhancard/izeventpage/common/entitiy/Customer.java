package com.shinhancard.izeventpage.common.entitiy;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @Column(length = 30, nullable = false)
    String name;
    @Column(length = 12, nullable = true)
    String hdp;
    @Column(length = 50, nullable = true)
    String email;
    @Column(length = 20, nullable = true)
    String favorite;
    @Column(length = 500, nullable = true)
    String message;

    @Column
    LocalDateTime niRgDt;

    @PrePersist
    public void createdAt() {
        this.niRgDt = LocalDateTime.now();
    }

}
