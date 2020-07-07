package com.captaincode.lendingengine.domain.model;

import java.time.Duration;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LoanApplication {

	@Id
	private long id;
	private  int amount;
	@ManyToOne
	private  User borrower;
	private  int  repaymentTermInDays;
	private  double interestRate;
	
	
	
	public LoanApplication() {
	}

	public LoanApplication(int amount, User borrower, int repaymentTermInDays, double interestRate) {
		super();
		this.amount = amount;
		this.borrower = borrower;
		this.repaymentTermInDays = repaymentTermInDays;
		this.interestRate = interestRate;
	}
	
	public int getAmount() {
		return amount;
	}
	public User getBorrower() {
		return borrower;
	}
	public int getRepaymentTermInDays() {
		return repaymentTermInDays;
	}
	public double getInterestRate() {
		return interestRate;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((borrower == null) ? 0 : borrower.hashCode());
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
		LoanApplication other = (LoanApplication) obj;
		if (amount != other.amount)
			return false;
		if (borrower == null) {
			if (other.borrower != null)
				return false;
		} else if (!borrower.equals(other.borrower))
			return false;
		if (Double.doubleToLongBits(interestRate) != Double.doubleToLongBits(other.interestRate))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "LoanRequest [amount=" + amount + ", borrower=" + borrower + ", interestRate=" + interestRate + "]";
	}
	
	
	
}
