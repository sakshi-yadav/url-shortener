package com.sakshi.urlShortenerService.service;

import org.springframework.stereotype.Service;

@Service
public interface UtilityService {
    void sendOtp(String mobile);

    void verifyOtp(String mobile, String otp);
}
