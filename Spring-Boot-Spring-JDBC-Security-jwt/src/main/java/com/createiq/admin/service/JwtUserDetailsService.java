package com.createiq.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private JdbcUserDetailsManager jdbcUserDetailsManager;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return jdbcUserDetailsManager.loadUserByUsername(username);
	}

}
