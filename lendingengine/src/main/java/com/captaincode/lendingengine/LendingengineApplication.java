package com.captaincode.lendingengine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.captaincode.lendingengine.domain.model.User;
import com.captaincode.lendingengine.domain.repository.UserRepository;

@SpringBootApplication
public class LendingengineApplication implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(LendingengineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
/*
 * 
 * Implementing the CommandLineRunner
 * Allows us to pre-populate the h2 instance in memory via the 
 * UserRepository with data
 */
			
			
		userRepository.save(new User("pico", "John", "Smith", 27, "Soft Developer"));
		userRepository.save(new User("rico", "Ptere", "James", 17, "General Admiistrator"));
		userRepository.save(new User("cheeko", "Onbn", "ZcD", 87, "Student"));
	}

}
