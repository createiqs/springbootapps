package com.createiq.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
	
	@GetMapping("/employees")
	public String employees() {
		return "employees";
	}
	
	@GetMapping("/newemployee")
	public String newemployee() {
		return "newemployee";
	}

}
