package com.captaincode.security.model;

import javax.persistence.Entity;
import javax.persistence.Id;

public class UserDTO {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private int age;
    private String occupation;

    public UserDTO() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}