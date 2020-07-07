package com.captaincode.lendingengine.application;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.captaincode.lendingengine.application.model.LoanRequest;
import com.captaincode.lendingengine.application.service.TokenValidationService;
import com.captaincode.lendingengine.domain.model.Loan;
import com.captaincode.lendingengine.domain.model.LoanApplication;
import com.captaincode.lendingengine.domain.model.User;
import com.captaincode.lendingengine.domain.repository.LoanApplicationRepository;
import com.captaincode.lendingengine.domain.repository.UserRepository;
import com.captaincode.lendingengine.service.LoanApplicationAdapter;
import com.captaincode.lendingengine.service.LoanService;

@RestController
public class LoanController {
	
	private final LoanApplicationRepository loanApplicationRepository;
	private final UserRepository userRepository;
	private final LoanApplicationAdapter loanApplicationAdapter;
	private final LoanService loanService;
	private final TokenValidationService tokenValidationService;
	
	@Autowired
	public LoanController(LoanApplicationRepository loanApplicationRepository, UserRepository userRepository,
			LoanApplicationAdapter loanApplicationAdapter, LoanService loanService,
			TokenValidationService tokenValidationService) {
		super();
		this.loanApplicationRepository = loanApplicationRepository;
		this.userRepository = userRepository;
		this.loanApplicationAdapter = loanApplicationAdapter;
		this.loanService = loanService;
		this.tokenValidationService = tokenValidationService;
	}
	
	@PostMapping(value = "/loan/request")
	public void requestloan(@RequestBody final LoanRequest loanRequest, HttpServletRequest request) {
		
		//@RequestBody  gets the body of the req object
		//HttpServletRequest gets full request incl header
		User  user = tokenValidationService.validateTokenAndGetToken(request.getHeader(HttpHeaders.AUTHORIZATION));
		//check the token is valid
		
		// transform LoanRequest to LoanApplication
		// An example o the Adapter pattern
		// via the service
		LoanApplication loanApplication = loanApplicationAdapter.transform(loanRequest, user);
		loanApplicationRepository.save(loanApplication);
		
	}


	@GetMapping(value= "/users")
	public List<User> findUsers(HttpServletRequest request){
		tokenValidationService.validateTokenAndGetToken(request.getHeader(HttpHeaders.AUTHORIZATION));
		return (List<User>) userRepository.findAll();
	}
	
	@GetMapping(value = "/loans/requests")
	public List<LoanApplication> findAllLoanApplications(HttpServletRequest request){
		User borrower = tokenValidationService.validateTokenAndGetToken(request.getHeader(HttpHeaders.AUTHORIZATION));
		return (List<LoanApplication>) loanApplicationRepository.findAll();
		
	}
	
	
	@PostMapping( value = "/loan/accept/loanApplicationId}")
	public void acceptLoan(@PathVariable final String loanApplicationId,
							HttpServletRequest request) {
		User lender = tokenValidationService.validateTokenAndGetToken(request.getHeader(HttpHeaders.AUTHORIZATION));
		loanService.acceptLoan(Long.parseLong(loanApplicationId), lender.getUsername());
		
	}
	
	@GetMapping(value="/loans")
	public List<Loan> findAllLoans(){
		return loanService.getAllLoans();
	}
	

}
