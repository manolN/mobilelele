package com.softuni.mobilelele.model.service;

import com.softuni.mobilelele.model.entity.UserRoleEntity;

import java.util.HashSet;
import java.util.Set;

public class UserRegisterServiceModel {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Set<UserRoleEntity> roles;

    public UserRegisterServiceModel() {
        this.roles = new HashSet<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterServiceModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public Set<UserRoleEntity> getRoles() {
        return roles;
    }

    public UserRegisterServiceModel setRoles(Set<UserRoleEntity> roles) {
        this.roles = roles;
        return this;
    }
}
