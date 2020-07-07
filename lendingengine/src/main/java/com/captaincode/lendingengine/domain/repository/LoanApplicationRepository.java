package com.captaincode.lendingengine.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.captaincode.lendingengine.domain.model.LoanApplication;

public interface LoanApplicationRepository extends CrudRepository<LoanApplication, Long >{

}
