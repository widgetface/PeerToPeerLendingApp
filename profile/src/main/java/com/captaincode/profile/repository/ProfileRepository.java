package com.captaincode.profile.repository;

import org.springframework.data.repository.CrudRepository;

import com.captaincode.profile.model.Profile;

public interface ProfileRepository extends CrudRepository<Profile, String> {

}
