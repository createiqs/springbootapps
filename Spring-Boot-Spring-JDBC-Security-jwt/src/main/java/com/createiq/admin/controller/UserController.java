package com.createiq.admin.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.createiq.admin.UserRegBean;
import com.createiq.admin.model.JwtRequest;
import com.createiq.admin.model.JwtResponse;
import com.createiq.admin.service.JwtUserDetailsService;
import com.createiq.admin.util.JwtTokenUtil;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private JdbcUserDetailsManager jdbcUserDetailsManager;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@GetMapping("/newReg")
	public String newReg() {
		return "newReg";
	}

	@PostMapping("/saveReg")
	public String saveReg(UserRegBean userRegBean, Model model) {
		List<GrantedAuthority> authorities = userRegBean.getRoles().stream().map(e -> new SimpleGrantedAuthority(e))
				.collect(Collectors.toList());
		User user = new User(userRegBean.getUsername(), bCryptPasswordEncoder.encode(userRegBean.getPassword()), authorities);
		jdbcUserDetailsManager.createUser(user);
		return "/home";
	}
	

	

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

}
