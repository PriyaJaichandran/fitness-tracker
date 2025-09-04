package com.fitness.service;

import com.fitness.entity.User;
import com.fitness.model.UserDTO;
import com.fitness.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    @Override
    public void createUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.name());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashed = encoder.encode(userDTO.password());
        user.setPassword(hashed.getBytes(StandardCharsets.UTF_8));
        user.setPhoneNumber(userDTO.phoneNumber());
        user.setCountryCode(userDTO.countryCode());
        user.setAge(userDTO.age());
        userRepository.save(user);
    }
}
