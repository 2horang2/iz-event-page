package com.shinhancard.izeventpage.config;

import java.util.concurrent.TimeUnit;

import com.shinhancard.izeventpage.interceptor.RequestInterceptor;
import com.shinhancard.izeventpage.interceptor.ResponseInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    RequestInterceptor requestInterceptor;
    @Autowired
    ResponseInterceptor responseInterceptor;

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/**").addResourceLocations("classpath:/templates/", "classpath:/static/")
                .setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES));
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(requestInterceptor).addPathPatterns("/**");
        registry.addInterceptor(responseInterceptor).addPathPatterns("/**");

    }

}
