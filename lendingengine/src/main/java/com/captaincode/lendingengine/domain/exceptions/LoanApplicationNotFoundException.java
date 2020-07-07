package com.captaincode.lendingengine.domain.exceptions;

public class LoanApplicationNotFoundException extends RuntimeException {

	public LoanApplicationNotFoundException(long loanApplicationId) {
	
		super("A loan with id " + loanApplicationId + " was not found");
	}

}
