package com.example;

public class Bank {
    private int bankId;
    private String bankName;

    // Constructor with args for constructor injection
    public Bank(int bankId, String bankName) {
        this.bankId = bankId;
        this.bankName = bankName;
    }

    // Getters
    public int getBankId() {
        return bankId;
    }

    public String getBankName() {
        return bankName;
    }

    // toString method to print details
    @Override
    public String toString() {
        return "Bank [bankId=" + bankId + ", bankName=" + bankName + "]";
    }
}
