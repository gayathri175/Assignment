package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example") // Adjust package if needed
public class CollegeConfig {

    @Bean
    public DormRoom dormRoom1() {
        return new DormRoom(101, "Maple Hall");
    }

    @Bean
    public DormRoom dormRoom2() {
        return new DormRoom(202, "Oak Hall");
    }
}
