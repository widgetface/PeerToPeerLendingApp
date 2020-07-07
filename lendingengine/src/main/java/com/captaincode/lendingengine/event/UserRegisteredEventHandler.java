package com.captaincode.lendingengine.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.captaincode.lendingengine.domain.model.User;
import com.captaincode.lendingengine.domain.repository.UserRepository;
import com.google.gson.Gson;

@Component
public class UserRegisteredEventHandler {
	
	private Logger LOGGER = LoggerFactory.getLogger(UserRegisteredEventHandler.class);
	private final Gson GSON = new Gson();
	private final UserRepository userRepository;
	
	@Autowired
	public UserRegisteredEventHandler(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	public void handleUserRegistration(String userDetails) {
		User user = GSON.fromJson(userDetails, User.class);
		LOGGER.info("user {} registered", user.getUsername());
		userRepository.save(user);
	}

}
