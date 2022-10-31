package com.alandsilva.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alandsilva.demo.dto.UserCreationDto;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @PostMapping
    public void createUser(UserCreationDto userCreationDto) {

    }
}
