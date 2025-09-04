package com.fitness.controller;

import com.fitness.model.ResponseDTO;
import com.fitness.model.UserDTO;
import com.fitness.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping
    public ResponseDTO createUser(@RequestBody UserDTO userDTO){
        userService.createUser(userDTO);
        return new ResponseDTO().builder().responseCode(200).message("user created successfully").build();
    }

}
