package com.shinhancard.izeventpage.common.controller;

import java.util.Optional;

import com.shinhancard.izeventpage.common.entitiy.Customer;
import com.shinhancard.izeventpage.common.entitiy.Event;
import com.shinhancard.izeventpage.common.entitiy.Log;
import com.shinhancard.izeventpage.common.repository.CustomerRepository;
import com.shinhancard.izeventpage.common.repository.EventRepository;
import com.shinhancard.izeventpage.common.repository.LogRepository;
import com.shinhancard.izeventpage.common.util.DateUtil;
import com.shinhancard.izeventpage.common.vo.ResponseVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "iz/api")
@Slf4j
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "OK !!"),
        @ApiResponse(responseCode = "400", description = "BAD REQUEST !!"),
        @ApiResponse(responseCode = "404", description = "NOT FOUND !!"),
        @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR !!")
})
public class EventController {

    @Autowired
    EventRepository eventRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    LogRepository logRepository;

    // @Operation(summary = "페이지방문 수 증가 API", description = "페이지 방문 시, 페이지 방문수가 증가되는
    // API")
    // @GetMapping(value = "/visitEventPage")
    // public ResponseEntity<ResponseVo> visitEventPage(@RequestParam Long eventId)
    // throws Exception {

    // Event event = eventRepository.findById((long) eventId).get();
    // event.increaseCount();
    // eventRepository.save(event);
    // log.debug("visitEventPage : " + event);

    // Log logVo = new Log(0L, eventId, 1, DateUtil.getDate("yyyyMMddHHmmss"));
    // log.debug("visitEventPage : " + logVo.toString());

    // logRepository.save(logVo);

    // log.debug("visitEventPage : " + logRepository.findAll());

    // ResponseVo responseVo = new ResponseVo("00", "성공입니다.");
    // return new ResponseEntity<>(responseVo, HttpStatus.OK);
    // }

    @Operation(summary = "고객 사전예약 API", description = "이벤트 페이지 내에서 고객이 입력한 사전예약 정보를 저장하는 API")
    @PostMapping(value = "/bookingEvent")
    public ResponseEntity<ResponseVo> bookingEvent(@RequestBody Customer customer) throws Exception {

        log.debug("bookingEvent : " + customer);

        ResponseVo responseVo = new ResponseVo("00", "성공입니다.");
        try {
            customerRepository.save(customer);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ResponseVo("99", "실패입니다."), HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity<>(responseVo, HttpStatus.OK);

    }
}
