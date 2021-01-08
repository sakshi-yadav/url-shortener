package com.loando.userService.dto.request;

import com.loando.userService.enums.UserType;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserRegistrationDTO implements Serializable {
    private static final long serialVersionUID = 1998882228888222L;

    private String email;
    private String password;
    private String phoneNumber;
    private UserType userType;
}
