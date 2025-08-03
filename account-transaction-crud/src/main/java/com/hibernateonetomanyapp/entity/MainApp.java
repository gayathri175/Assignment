package com.hibernateonetomanyapp.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        Account account = new Account();
        account.setHolderName(name);

        List<Transaction> transactionList = new ArrayList<>();

        System.out.print("How many transactions to add? ");
        int count = sc.nextInt();

        for (int i = 0; i < count; i++) {
            sc.nextLine(); // consume newline
            Transaction tx = new Transaction();

            System.out.print("Enter Transaction Type: ");
            tx.setType(sc.nextLine());

            System.out.print("Enter Amount: ");
            tx.setAmount(sc.nextDouble());

            tx.setAccount(account);
            transactionList.add(tx);
        }

        account.setTransactions(transactionList);

        // Save to DB
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction htx = session.beginTransaction();


        session.save(account);

        htx.commit();
        session.close();

        System.out.println("Account with transactions saved!");
    }
}

