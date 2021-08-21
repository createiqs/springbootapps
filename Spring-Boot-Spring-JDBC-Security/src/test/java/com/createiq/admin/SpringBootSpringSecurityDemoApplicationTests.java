package com.createiq.admin;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SpringBootSpringSecurityDemoApplicationTests {

	@Test
	void contextLoads() {
		String encoded = new BCryptPasswordEncoder().encode("balaji");
		System.out.println(encoded);
	}

}
