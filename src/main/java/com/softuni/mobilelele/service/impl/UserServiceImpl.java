package com.softuni.mobilelele.service.impl;

import com.softuni.mobilelele.model.entity.UserEntity;
import com.softuni.mobilelele.model.entity.UserRoleEntity;
import com.softuni.mobilelele.model.service.UserRegisterServiceModel;
import com.softuni.mobilelele.repository.UserRepository;
import com.softuni.mobilelele.repository.UserRoleRepository;
import com.softuni.mobilelele.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper mapper;
    private final UserRoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           ModelMapper mapper, UserRoleRepository roleRepository) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
        this.roleRepository = roleRepository;
    }

    @Override
    public boolean register(UserRegisterServiceModel registerServiceModel) {
        Optional<UserEntity> optUser = userRepository.findByUsername(registerServiceModel.getUsername());

        if (!optUser.isEmpty()) {
            return false;
        }

        UserRoleEntity userRole = roleRepository.findById(Long.parseLong("2")).orElse(null);

        UserEntity user = mapper.map(registerServiceModel, UserEntity.class).setRoles(Set.of(userRole));
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);
        return true;
    }

    @Override
    public UserEntity findUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
}
