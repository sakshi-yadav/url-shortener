package com.loando.userService.service;

import com.loando.userService.dto.request.UserRegistrationDTO;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {
    public void createUser(UserRegistrationDTO userRegistrationDTO);
}
