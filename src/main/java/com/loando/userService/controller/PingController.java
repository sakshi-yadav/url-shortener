package com.loando.userService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ping")
public class PingController {
    @Autowired
    private Environment environment;

    @GetMapping
    public String ping(){
        return "Pong with port : " + environment.getProperty("local.server.port");
    }
}
