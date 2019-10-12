package com.spring.movi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/@m!n")
public class HomeController {
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

//    @GetMapping(value = "/")
//    public String index() {
//        return "index";
//    }

    @GetMapping(value = "/")
    public String adminIndex() {
        log.debug("debug");
        log.error("error");
        log.info("info");
        log.trace("trace");
        return "admin/pages/index";
    }

    @GetMapping(value = "/u")
    public String userIndex() {
        return "admin/pages/user/index";
    }

    @GetMapping(value = "/kendo")
    public String KendoIndex() {
        return "admin/kendo";
    }

    @GetMapping(value = "/exchangerate")
    public  String exChangeRate() {
        return "admin/pages/home";
    }
}
