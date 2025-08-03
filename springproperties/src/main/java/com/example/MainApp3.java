package com.example;

import java.util.Scanner;

public class MainApp3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User Input
        System.out.print("Enter Account Number: ");
        int number = sc.nextInt();
        sc.nextLine(); // consume leftover newline

        System.out.print("Enter Account Holder Name: ");
        String holder = sc.nextLine();

        System.out.print("Enter Account Balance: ");
        double balance = sc.nextDouble();
        sc.nextLine(); // consume leftover newline

        System.out.print("Enter Account Type (e.g., Savings/Current): ");
        String type = sc.nextLine();

        // Create Account object
        Account3 acc = new Account3(number, holder, balance, type);

        // Display details
        acc.display();
    }
}
