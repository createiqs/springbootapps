package com.createiq.admin;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {
	
	public static void main(String[] args) {
		String encoded = new BCryptPasswordEncoder().encode("balaji");
		System.out.println(encoded);
	}

}
