package com.captaincode.lendingengine.application.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.captaincode.lendingengine.domain.exceptions.UserNotFoundException;
import com.captaincode.lendingengine.domain.model.User;
import com.captaincode.lendingengine.domain.repository.UserRepository;

@Component
public class TokenValidationService {

	 @Value("${security.baseurl}")
	 private String securityContextBaseUrl;
	private UserRepository userRepository;
	private RestTemplate restTemplate = new RestTemplate();
    

	@Autowired
	public TokenValidationService(UserRepository userRepository) {
		this.userRepository = userRepository;
		
	}
	
	
	public User validateTokenAndGetToken(final String token) {
		
		System.out.println(token);
		//set up Auth header
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add(HttpHeaders.AUTHORIZATION, token);
		HttpEntity httpEntity = new HttpEntity(httpHeaders);
	
		// make request
		ResponseEntity<String> response = restTemplate.exchange(securityContextBaseUrl+"/user/validate", HttpMethod.POST, httpEntity, String.class);
		if(response.getStatusCode().equals(HttpStatus.OK)) {
			return userRepository.findById(response.getBody()).orElseThrow( () -> new UserNotFoundException(response.getBody()));
			
		}
		
		throw new RuntimeException("invalid token");
	}
	
}
