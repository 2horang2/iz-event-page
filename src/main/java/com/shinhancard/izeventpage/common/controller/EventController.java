package com.shinhancard.izeventpage.common.controller;

import com.shinhancard.izeventpage.common.entitiy.Event;
import com.shinhancard.izeventpage.common.repository.EventRepository;
import com.shinhancard.izeventpage.common.vo.EventVo;
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

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "iz/api")
@Slf4j
public class EventController {

    @Autowired
    EventRepository eventRepository;

    @GetMapping(value = "/sampleGetApi")
    public ResponseEntity<ResponseVo> sampleGetApi(@RequestParam String id) throws Exception {

        if (id.equals("1"))
            throw new Exception("실패입니다.");

        ResponseVo responseVo = new ResponseVo("00", "성공입니다.");
        return new ResponseEntity<>(responseVo, HttpStatus.OK);
    }

    @PostMapping(value = "/samplePostApi")
    public ResponseEntity<ResponseVo> samplePostApi(@RequestBody EventVo input) {
        ResponseVo responseVo = new ResponseVo();
        return new ResponseEntity<>(responseVo, HttpStatus.OK);
    }

    @GetMapping(value = "/visitEventPage")
    public ResponseEntity<ResponseVo> visitEventPage(@RequestParam Long eventId) throws Exception {

        Event event = eventRepository.findByEventId((long) eventId);
        event.increaseCount();
        eventRepository.save(event);
        log.debug("visitEventPage : " + event);

        ResponseVo responseVo = new ResponseVo("00", "성공입니다.");
        return new ResponseEntity<>(responseVo, HttpStatus.OK);
    }
}
