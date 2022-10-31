package com.alandsilva.demo.service;

import com.alandsilva.demo.dto.UserCreationDto;
import com.alandsilva.demo.model.User;

public interface UserService {
    void createUser(UserCreationDto userCreationDto);
}
