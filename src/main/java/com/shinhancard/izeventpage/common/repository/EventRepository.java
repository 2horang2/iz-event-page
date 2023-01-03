package com.shinhancard.izeventpage.common.repository;

import com.shinhancard.izeventpage.common.entitiy.Event;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

    Event findByEventId(long eventId);

    int deleteByEventId(long eventId);
}
