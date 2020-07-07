package com.captaincode.profile.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.captaincode.profile.model.Profile;
import com.captaincode.profile.repository.ProfileRepository;

@RestController
@RequestMapping("/profile")
public class ProfileController {
	private final ProfileRepository profileRepository;
	@Autowired
	public ProfileController(ProfileRepository profileRepository) {
		this.profileRepository = profileRepository;
	}

	@GetMapping(value="/users")
	public List<Profile> findAllProfiles(){
		return (List<Profile>) profileRepository.findAll();
	}
	
	@PostMapping(value="/user")
	public void createUser(@RequestBody Profile user) {
		profileRepository.save(user);
		
	}
	
	@PutMapping(value="/user")
	public void updateUser(@RequestBody Profile user) {
		
		profileRepository.save(user);
		
	}
}
