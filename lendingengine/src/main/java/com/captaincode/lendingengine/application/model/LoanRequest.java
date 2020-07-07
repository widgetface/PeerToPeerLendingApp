package com.captaincode.lendingengine.application.model;

/*
 * 
 * This class maps the controller request body data to
 *  the @Entity LoanApplication class via the @Service LoanService 
 */
import com.captaincode.lendingengine.domain.model.User;

public class LoanRequest {

	private final int amount;
	private final int daysToRepay;
	private final double interestRate;
	
	public LoanRequest(int amount,int daysToRepay, double interestRate) {
		super();
		this.amount = amount;
		this.daysToRepay = daysToRepay;
		this.interestRate = interestRate;
	}
	

	public int getAmount() {
		return amount;
	}

	public int getDaysToRepay() {
		return daysToRepay;
	}


	public double getInterestRate() {
		return interestRate;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + daysToRepay;
		long temp;
		temp = Double.doubleToLongBits(interestRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanRequest other = (LoanRequest) obj;
		if (amount != other.amount)
			return false;
		
		if (daysToRepay != other.daysToRepay)
			return false;
		if (Double.doubleToLongBits(interestRate) != Double.doubleToLongBits(other.interestRate))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "LoanRequest [amount=" + amount +  ", daysToRepay=" + daysToRepay
				+ ", interestRate=" + interestRate + "]";
	}


	
	
}
