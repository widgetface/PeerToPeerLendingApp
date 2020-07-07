package com.captaincode.lendingengine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.captaincode.lendingengine.domain.exceptions.LoanApplicationNotFoundException;
import com.captaincode.lendingengine.domain.exceptions.UserNotFoundException;
import com.captaincode.lendingengine.domain.model.Loan;
import com.captaincode.lendingengine.domain.model.LoanApplication;
import com.captaincode.lendingengine.domain.model.User;
import com.captaincode.lendingengine.domain.repository.LoanApplicationRepository;
import com.captaincode.lendingengine.domain.repository.LoanRepository;
import com.captaincode.lendingengine.domain.repository.UserRepository;

@Component
public class LoanService {
	
	private final LoanApplicationRepository loanApplicationRepository;
	private final UserRepository userRepository;
	private final LoanRepository loanRepository;

	@Autowired
	public LoanService(LoanApplicationRepository loanApplicationRepository, UserRepository userRepository,
			LoanRepository loanRepository) {
		super();
		this.loanApplicationRepository = loanApplicationRepository;
		this.userRepository = userRepository;
		this.loanRepository = loanRepository;
	}
	
	
	public void acceptLoan(final long loanApplicationId , final String lenderId) {
		// Note the nice use o a lambda here to throw exception if user not found
		User lender = userRepository.findById(lenderId).orElseThrow( () -> new UserNotFoundException(lenderId));
		LoanApplication loanApplication = loanApplicationRepository.findById(loanApplicationId).orElseThrow( () -> new LoanApplicationNotFoundException(loanApplicationId));
		
		loanRepository.save(new Loan(lender, loanApplication));
	
	}
	
	public List<Loan> getAllLoans(){
		return (List<Loan>) loanRepository.findAll();
	}
}
