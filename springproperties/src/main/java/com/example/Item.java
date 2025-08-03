package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Item {
    private int id;
    private String name;
    private double price;

    @Autowired
    private Category category;

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    // Display method
    public void display() {
        System.out.println("\n==== Item Details ====");
        System.out.println("Item ID: " + id);
        System.out.println("Item Name: " + name);
        System.out.println("Item Price: " + price);
        System.out.println("== Category Details ==");
        category.displayCategory();
    }
}
