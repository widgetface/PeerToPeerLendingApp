package com.captaincode.lendingengine.service;

import java.time.Duration;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.captaincode.lendingengine.application.model.LoanRequest;
import com.captaincode.lendingengine.domain.exceptions.UserNotFoundException;
import com.captaincode.lendingengine.domain.model.LoanApplication;
import com.captaincode.lendingengine.domain.model.User;
import com.captaincode.lendingengine.domain.repository.UserRepository;


@Component
public class LoanApplicationAdapter {
	
	
	private final UserRepository userRepository;
	
	
	@Autowired
	public LoanApplicationAdapter(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}



	public LoanApplication transform(LoanRequest req, User borrower) {
		String userId = borrower.getUsername();
		Optional<User> userOptional = userRepository.findById(userId);
		
		if(userOptional.isPresent()) {
			return new LoanApplication(req.getAmount(), userOptional.get(),req.getDaysToRepay(),req.getInterestRate());
		}else {
			throw new UserNotFoundException(userId);
		}
	
		
	}

}
