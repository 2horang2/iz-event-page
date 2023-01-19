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
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @Column
    String ip;
    @Column
    String agent;
    @Column
    String refer;
    @Column
    LocalDateTime niRgDt;

    @PrePersist
    public void createdAt() {
        this.niRgDt = LocalDateTime.now();
    }

}
