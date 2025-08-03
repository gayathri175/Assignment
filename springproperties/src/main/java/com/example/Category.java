package com.example;

import org.springframework.stereotype.Component;

@Component
public class Category {
    private int categoryId;
    private String categoryName;

    // Setters
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    // Display method
    public void displayCategory() {
        System.out.println("Category ID: " + categoryId);
        System.out.println("Category Name: " + categoryName);
    }
}
