package com.softuni.mobilelele.model.binding;

import com.softuni.mobilelele.model.entity.UserRoleEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

public class UserRegisterBindingModel {

    @NotBlank
    @Size(min = 2, max = 20)
    private String firstName;
    @NotBlank
    @Size(min = 2, max = 20)
    private String lastName;
    @NotBlank
    @Size(min = 4, max = 20)
    private String username;
    @NotBlank
    @Size(min = 4, max = 20)
    private String password;
    private Set<UserRoleEntity> roles;

    public UserRegisterBindingModel() {
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterBindingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public Set<UserRoleEntity> getRoles() {
        return roles;
    }

    public UserRegisterBindingModel setRoles(Set<UserRoleEntity> roles) {
        this.roles = roles;
        return this;
    }
}
