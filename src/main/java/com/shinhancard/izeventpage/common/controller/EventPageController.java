package com.shinhancard.izeventpage.common.controller;

import javax.servlet.http.HttpServletRequest;

import com.shinhancard.izeventpage.common.entitiy.Customer;
import com.shinhancard.izeventpage.common.entitiy.Log;
import com.shinhancard.izeventpage.common.repository.CustomerRepository;
import com.shinhancard.izeventpage.common.repository.LogRepository;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/iz/event-page")
@Slf4j
@RequiredArgsConstructor
public class EventPageController {

    final private CustomerRepository customerRepository;
    final private LogRepository logRepository;

    // @GetMapping
    // public void init(HttpServletRequest request) {
    // log.info("init init");
    // log.info("init " + request.getLocalAddr());
    // log.info("init " + request.getRemoteAddr());
    // log.info("init " + request.getRemoteHost());
    // }

    @PostMapping(value = "/submit.do")
    public String submit(HttpServletRequest request, Customer customer) {
        log.info("loggg " + customer.toString());
        log.info("loggg " + request.getLocalAddr());
        log.info("loggg " + request.getRemoteAddr());
        log.info("loggg " + request.getRemoteHost());
        // Customer customer = new Customer();
        // customer.setName(model.getName());

        customerRepository.save(customer);

        try {
            Log log = new Log();
            log.setIp(request.getRemoteAddr());
            log.setIp(request.getHeader("referer"));
            log.setAgent(request.getHeader("User-Agent"));
            logRepository.save(log);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

}
