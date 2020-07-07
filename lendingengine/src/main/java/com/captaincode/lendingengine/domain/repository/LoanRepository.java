package com.captaincode.lendingengine.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.captaincode.lendingengine.domain.model.Loan;

public interface LoanRepository extends CrudRepository<Loan, Long>{

}
