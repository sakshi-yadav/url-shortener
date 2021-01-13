package com.loando.userService.launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication()
@ComponentScan("com.**")
@EnableDiscoveryClient
@EnableTransactionManagement
@RefreshScope
public class BffConsumerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BffConsumerServiceApplication.class, args);
    }
}