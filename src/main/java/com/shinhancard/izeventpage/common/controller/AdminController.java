package com.shinhancard.izeventpage.common.controller;

import java.util.List;

import com.shinhancard.izeventpage.common.entitiy.Customer;
import com.shinhancard.izeventpage.common.entitiy.Event;
import com.shinhancard.izeventpage.common.repository.CustomerRepository;
import com.shinhancard.izeventpage.common.repository.EventRepository;
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
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "iz/api/admin")
@Slf4j
public class AdminController {
    @Autowired
    EventRepository eventRepository;
    @Autowired
    CustomerRepository customerRepository;

    @Operation(summary = "이벤트정보 전체조회 API", description = "현재 운영중인 이벤트 정보를 모두 보여주는 API")
    @GetMapping(value = "/findAllEvent")
    public ResponseEntity<List<Event>> findAllEvent() throws Exception {
        return new ResponseEntity<>(eventRepository.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "사전예약 전체조회 API", description = "현재 신청된 사전예약 정보를 모두 보여주는 API")
    @GetMapping(value = "/findAllCustomer")
    public ResponseEntity<List<Customer>> findAllCustomer() throws Exception {
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "사전예약 등록 API", description = "사전예약을 신규등록하는 API")
    @PostMapping(value = "/saveCustomer")
    public ResponseEntity<ResponseVo> saveCustomer(@RequestBody Customer customer) throws Exception {

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

    @Operation(summary = "이벤트정보 등록 API", description = "이벤트 정보를 신규등록하는 API")
    @PostMapping(value = "/saveEvent")
    public ResponseEntity<ResponseVo> saveEvent(@RequestBody Event event) throws Exception {

        log.debug("bookingEvent : " + event);

        ResponseVo responseVo = new ResponseVo("00", "성공입니다.");
        try {
            eventRepository.save(event);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ResponseVo("99", "실패입니다."), HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>(responseVo, HttpStatus.OK);

    }

    @Operation(summary = "이벤트정보 삭제 API", description = "이벤트 정보를 삭제하는 API")
    @PostMapping(value = "/deleteEvent")
    public ResponseEntity<ResponseVo> deleteEvent(@RequestParam Long eventId) throws Exception {

        log.debug("deleteEvent : " + eventId);

        ResponseVo responseVo = new ResponseVo("00", "성공입니다.");
        try {
            eventRepository.deleteByEventId(eventId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ResponseVo("99", "실패입니다."), HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>(responseVo, HttpStatus.OK);

    }

    @Operation(summary = "이벤트정보 수정 API", description = "이벤트 정보를 수정하는 API")
    @PostMapping(value = "/updateEvent")
    public ResponseEntity<ResponseVo> updateEvent(@RequestBody Event event) throws Exception {

        log.debug("bookingEvent : " + event);

        ResponseVo responseVo = new ResponseVo("00", "성공입니다.");
        try {
            eventRepository.deleteByEventId(event.getEventId());
            eventRepository.save(event);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ResponseVo("99", "실패입니다."), HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>(responseVo, HttpStatus.OK);

    }

}
