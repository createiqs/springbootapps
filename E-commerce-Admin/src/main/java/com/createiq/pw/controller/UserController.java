package com.createiq.pw.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.createiq.pw.domin.Book;
import com.createiq.pw.domin.User;
import com.createiq.pw.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody User user) {
		// LOGGER.debug("Book", book);
		log.debug("User", user);
		HttpHeaders headers = new HttpHeaders();
		ResponseEntity<?> responseEntity = new ResponseEntity<>(userService.saveOrUpdate(user), headers, HttpStatus.OK);
		return responseEntity;
	}
}
