package com.shinhancard.izeventpage.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shinhancard.izeventpage.common.entitiy.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

}
