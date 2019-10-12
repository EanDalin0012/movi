package com.spring.movi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/@m!n/type")
public class TypeController {
	// private static final Logger log = LoggerFactory.getLogger(HomeContoller.class);

	@GetMapping(value = "/")
	public String index() {
		return "admin/pages/type/index";
	}
}
