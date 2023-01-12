package com.shinhancard.izeventpage.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontController {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

}
