package com.captaincode.lendingengine.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.captaincode.lendingengine.domain.model.User;

public interface UserRepository extends CrudRepository<User, String>{

}
