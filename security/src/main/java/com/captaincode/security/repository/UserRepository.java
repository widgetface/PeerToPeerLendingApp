package com.captaincode.security.repository;

import org.springframework.data.repository.CrudRepository;

import com.captaincode.security.user.User;

public interface UserRepository extends CrudRepository<User, String>{
	
}