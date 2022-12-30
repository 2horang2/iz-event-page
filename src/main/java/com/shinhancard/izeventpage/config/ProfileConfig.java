package com.shinhancard.izeventpage.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class ProfileConfig {

    @Value("${project.envCcd}")
    String profileCcd;

    @Bean
    public void initProfileCcd() {
        log.info("profileCcd : " + profileCcd);
    }

}
