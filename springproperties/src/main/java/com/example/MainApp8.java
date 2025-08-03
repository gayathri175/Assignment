package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp8 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
        
        ShoppingService shoppingService = (ShoppingService) context.getBean("shoppingService");

        // call some methods on shoppingService to test AOP advices
        shoppingService.addToCart("Laptop");
        shoppingService.makePayment(1500.0);
        shoppingService.placeOrder();
    }
}
