package com.captaincode.security.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.captaincode.security.model.UserDTO;
import com.captaincode.security.user.User;
import com.google.gson.Gson;

@Component
public class NotificationService {
	
	private final RabbitTemplate rabbitTemplate;
	private final static Gson GSON = new Gson();
	@Autowired
	public NotificationService(RabbitTemplate rabbitTemplate) {
		super();
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public void sendMessage(UserDTO userDTO) {
		userDTO.setPassword(null); // keep password within security bounded context
		rabbitTemplate.convertAndSend("userRegisteredTopic", "user.registered", GSON.toJson(userDTO));
	}
	

}
