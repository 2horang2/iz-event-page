package com.shinhancard.izeventpage.config;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class ProfileConfig {

    public static String getIp() {
        String result = null;
        try {
            result = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            result = "";
        }
        return result;
    }

    @Value("${project.envCcd}")
    String profileCcd;

    @Bean
    public void initProfileCcd() {
        log.info("profileCcd : " + profileCcd);
        log.info("serverIp : " + getIp());
    }

}
