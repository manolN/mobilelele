package com.softuni.mobilelele.service;

import com.softuni.mobilelele.model.entity.UserEntity;
import com.softuni.mobilelele.model.service.UserLoginServiceModel;
import com.softuni.mobilelele.model.service.UserRegisterServiceModel;

public interface UserService {

    boolean register(UserRegisterServiceModel registerServiceModel);

    UserEntity findUserByUsername(String username);
}
