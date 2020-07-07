package com.captaincode.lendingengine.domain.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;

@Entity
public class Loan {
	
	@Id
	@GeneratedValue()
	private long id;
	@ManyToOne // a borrower can have many loans
	private User borrower;
	@ManyToOne // a lender can lend to many
	private User lender;
	private int amount;
	private double interestRate;
	private LocalDate dateLent;
	private LocalDate dateDue;

	public Loan() {

	}


	public Loan(User lender, LoanApplication loanApplication) {
		
		this.borrower = loanApplication.getBorrower();
		this.lender = lender;
		this.amount = loanApplication.getAmount();
		this.interestRate = loanApplication.getInterestRate();	
		this.dateLent = LocalDate.now();
		this.dateDue = LocalDate.now().plusDays(loanApplication.getRepaymentTermInDays());
	}


	public long getId() {
		return id;
	}


	public User getBorrower() {
		return borrower;
	}


	public User getLender() {
		return lender;
	}


	public int getAmount() {
		return amount;
	}


	public double getInterestRate() {
		return interestRate;
	}


	public LocalDate getDateLent() {
		return dateLent;
	}


	public LocalDate getDateDue() {
		return dateDue;
	}


	@Override
	public String toString() {
		return "Loan [id=" + id + ", borrower=" + borrower + ", lender=" + lender + ", amount=" + amount
				+ ", interestRate=" + interestRate + ", dateLent=" + dateLent + ", dateDue=" + dateDue + "]";
	}
	

}
