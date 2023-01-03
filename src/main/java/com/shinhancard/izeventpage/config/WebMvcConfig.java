package com.shinhancard.izeventpage.config;

import com.shinhancard.izeventpage.interceptor.RequestInterceptor;
import com.shinhancard.izeventpage.interceptor.ResponseInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.RequiredArgsConstructor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    RequestInterceptor requestInterceptor;
    @Autowired
    ResponseInterceptor responseInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(requestInterceptor).addPathPatterns("/**");
        registry.addInterceptor(responseInterceptor).addPathPatterns("/**");

    }

}
