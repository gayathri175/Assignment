package com.example.grocery.controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
 
@RestController
@RequestMapping("/grocery")
public class GroceryController {
 
    @GetMapping("/public")
    public String publicAccess() {
        return "Welcome to the Grocery Store - Public Endpoint!";
    }
 
    @GetMapping("/items")
    public List<String> getItems() {
        return Arrays.asList("Apples", "Bananas", "Milk", "Bread");
    }
 
    @GetMapping("/orders")
    public List<String> getOrders() {
        return Arrays.asList("Order#123 - Milk", "Order#124 - Bread");
    }
}