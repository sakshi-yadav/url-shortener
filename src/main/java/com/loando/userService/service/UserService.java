package com.loando.userService.service;

import com.loando.userService.dto.request.UserRegistrationDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public void createUser(UserRegistrationDTO userRegistrationDTO);
}
