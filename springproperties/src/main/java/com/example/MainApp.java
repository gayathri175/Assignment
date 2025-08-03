package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // Load spring XML config file
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // Get account bean
        Account account = (Account) context.getBean("account");

        // Call method to print details
        account.printDetails();
    }
}
