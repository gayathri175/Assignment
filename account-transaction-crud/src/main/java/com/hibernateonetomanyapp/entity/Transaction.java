package com.hibernateonetomanyapp.entity;

import javax.persistence.*;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double amount;
    private String type;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    // Getters and setters
    public int getId() { return id; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public Account getAccount() { return account; }
    public void setAccount(Account account) { this.account = account; }
}

