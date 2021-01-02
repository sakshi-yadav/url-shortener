package com.loando.userService.launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@ComponentScan("com.loando.**")
public class BffConsumerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BffConsumerServiceApplication.class, args);
    }
}