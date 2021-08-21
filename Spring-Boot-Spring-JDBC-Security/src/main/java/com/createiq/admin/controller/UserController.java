package com.createiq.admin.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.createiq.admin.UserRegBean;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private JdbcUserDetailsManager jdbcUserDetailsManager;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping("/newReg")
	public String newReg() {
		return "newReg";
	}

	@PostMapping("/saveReg")
	public String saveReg(UserRegBean userRegBean, Model model) {
		System.out.println(userRegBean);
		List<GrantedAuthority> authorities = userRegBean.getRoles().stream().map(e -> new SimpleGrantedAuthority(e))
				.collect(Collectors.toList());
		User user = new User(userRegBean.getUsername(), bCryptPasswordEncoder.encode(userRegBean.getPassword()), authorities);
		jdbcUserDetailsManager.createUser(user);
		return "/home";
	}

}
