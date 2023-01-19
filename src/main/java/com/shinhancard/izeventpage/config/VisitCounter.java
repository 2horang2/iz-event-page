package com.shinhancard.izeventpage.config;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.shinhancard.izeventpage.common.entitiy.Log;
import com.shinhancard.izeventpage.common.repository.LogRepository;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.support.WebApplicationContextUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@WebListener
public class VisitCounter implements HttpSessionListener {

    private final LogRepository logRepository;

    @Override
    public void sessionCreated(HttpSessionEvent arg0) {
        HttpSession session = arg0.getSession();
        WebApplicationContext wac = WebApplicationContextUtils
                .getRequiredWebApplicationContext(session.getServletContext());

        Log log = new Log();
        log.setIp(session.getId());
        // log.setRefer(req.getHeader("referer"));
        // log.setAgent(req.getHeader("User-Agent"));

        logRepository.save(log);
        // // 등록되어있는 빈을 사용할수 있도록 설정해준다

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent arg0) {
        // TODO Auto-generated method stub
    }
}
