package com.shinhancard.izeventpage.config;

import com.shinhancard.izeventpage.common.entitiy.Event;
import com.shinhancard.izeventpage.common.repository.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@Order(2)
public class EventInitConfig {

    @Autowired
    EventRepository eventRepository;

    @Value("${project.envCcd}")
    String profileCcd;

    @Bean
    void initData() {

        if ("D".equals(profileCcd)) {
            eventRepository.save(new Event(1L, "이름", "설명", 0));
            eventRepository.save(new Event(2L, "이름2", "설명2", 0));
            eventRepository.save(new Event(3L, "이름3", "설명3", 0));
        }

        log.debug("initData \n" + eventRepository.findAll());

    }
}
