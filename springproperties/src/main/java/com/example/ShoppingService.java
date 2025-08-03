package com.example;

public class ShoppingService {

    public void addToCart(String item) {
        System.out.println("Adding item to cart: " + item);
    }

    public void makePayment(double amount) {
        if(amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive!");
        }
        System.out.println("Payment made: $" + amount);
    }

    public void placeOrder() {
        System.out.println("Order placed successfully.");
    }
}
