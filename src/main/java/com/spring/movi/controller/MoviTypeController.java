package com.spring.movi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/@m!n/movitype")
public class MoviTypeController {

	@GetMapping(value = "/")
	public String index() {
		return "admin/pages/movitype/index";
	}
}
