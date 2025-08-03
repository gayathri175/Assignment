package com.example;

public class Account {
    private int accountNumber;
    private String accountHolderName;
    private double balance;
    private Bank bank;  // reference to Bank class

    // Constructor with args for constructor injection
    public Account(int accountNumber, String accountHolderName, double balance, Bank bank) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.bank = bank;
    }

    // Method to print account and bank details
    public void printDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
        System.out.println("Bank Details: " + bank);
    }
}
