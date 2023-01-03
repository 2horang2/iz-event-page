package com.shinhancard.izeventpage.interceptor;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ResponseInterceptor implements HandlerInterceptor {

    @PostConstruct
    public void init() {
        // log.info("[aop-test] interceptor : ResponseInterceptor init()");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // log.info("[aop-test] interceptor : ResponseInterceptor preHandle()");
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable Exception ex) throws Exception {

        if (ex != null)
            log.error("[aop-test] interceptor [EXCEPTION 발생] " + ex.getMessage());
    }

}
