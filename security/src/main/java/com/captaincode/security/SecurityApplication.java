package com.captaincode.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.captaincode.security.user.User;
import com.captaincode.security.repository.UserRepository;

@SpringBootApplication
public class SecurityApplication  implements CommandLineRunner{ 

	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {	
		userRepository.save(new User("pico", "password"));
		userRepository.save(new User("cheeko", "password"));
	}

}
