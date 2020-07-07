package com.captaincode.security.application;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.captaincode.security.exception.UserNotFoundException;
import com.captaincode.security.model.UserDTO;
import com.captaincode.security.repository.UserRepository;
import com.captaincode.security.service.NotificationService;
import com.captaincode.security.user.User;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private final UserRepository userRepository;
	private final NotificationService notificationService;
	
	
	@Autowired
	public UserController(UserRepository userRepository, NotificationService notificationService) {
		this.userRepository = userRepository;
		this.notificationService = notificationService;
	}
	
	@PostMapping("/register")
	public void register(@RequestBody UserDTO userDTO) {
		User user = new User( userDTO.getUsername(), userDTO.getPassword());
		userRepository.save(user);
		notificationService.sendMessage(userDTO);
	}

	@PostMapping(value="/validate")
	public String validateTokenAndGetUsername(@RequestHeader("Authorization") String token) {
		return userRepository.findById(token).orElseThrow(() -> new UserNotFoundException()).getUsername();
	}

}