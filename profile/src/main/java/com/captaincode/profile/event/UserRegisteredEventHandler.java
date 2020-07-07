package com.captaincode.profile.event;

import com.google.gson.Gson;
import com.captaincode.profile.model.Profile;
import com.captaincode.profile.repository.ProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRegisteredEventHandler {

    private Logger LOGGER = LoggerFactory.getLogger(UserRegisteredEventHandler.class);
    private static final Gson GSON = new Gson();
    private final ProfileRepository userRepository;

    @Autowired
    public UserRegisteredEventHandler(ProfileRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void handleUserRegistration(String userDetails) {
        Profile profile = GSON.fromJson(userDetails, Profile.class);
        LOGGER.info("user {} registered", profile.getUsername());
        userRepository.save(profile);
    }
}