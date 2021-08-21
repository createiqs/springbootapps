package com.createiq.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping(value = {"/","/home"})
	public String home() {
		return "home";
	}
	
	@GetMapping(value = {"/welcome"})
	public String welcome() {
		return "welcome";
	}

}
