package com.example;

public class Account3 {
    private int number;
    private String holder;
    private double balance;
    private String type;

    // Constructor
    public Account3(int number, String holder, double balance, String type) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.type = type;
    }

    // Display method
    public void display() {
        System.out.println("\n========= Account Details =========");
        System.out.println("Account Number: " + number);
        System.out.println("Account Holder: " + holder);
        System.out.println("Account Balance: " + balance);
        System.out.println("Account Type: " + type);
    }
}
