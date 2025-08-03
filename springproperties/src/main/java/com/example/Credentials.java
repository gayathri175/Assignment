package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:datafile.properties")
public class Credentials {

    @Value("${URL}")
    private String url;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    // Getters to access the values
    public String getUrl() {
        return url;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
}
