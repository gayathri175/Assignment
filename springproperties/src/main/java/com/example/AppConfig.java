package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example")
public class AppConfig {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Credentials credentials = context.getBean(Credentials.class);

        System.out.println("URL: " + credentials.getUrl());
        System.out.println("Username: " + credentials.getUsername());
        System.out.println("Password: " + credentials.getPassword());
    }
}
