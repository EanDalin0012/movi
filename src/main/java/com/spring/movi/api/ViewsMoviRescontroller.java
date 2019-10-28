package com.spring.movi.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/@m!n/api/viewsmovi")
public class ViewsMoviRescontroller {
    private static final Logger log = LoggerFactory.getLogger(TypeRecontroller.class);

    @GetMapping(value = "/")
    public String index(){
        return "index";
    }
}
