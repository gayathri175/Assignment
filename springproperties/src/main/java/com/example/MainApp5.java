package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp5 {
    public static void main(String[] args) {
        // Load Spring context
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Get beans
        Item item = context.getBean(Item.class);
        Category category = item.getCategory();

        // Get user input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Item ID: ");
        item.setId(sc.nextInt());
        sc.nextLine(); // consume newline

        System.out.print("Enter Item Name: ");
        item.setName(sc.nextLine());

        System.out.print("Enter Item Price: ");
        item.setPrice(sc.nextDouble());
        sc.nextLine();

        System.out.print("Enter Category ID: ");
        category.setCategoryId(sc.nextInt());
        sc.nextLine();

        System.out.print("Enter Category Name: ");
        category.setCategoryName(sc.nextLine());

        // Display
        item.display();
    }
}

//Sample Output:
/*
Enter Item ID: 101
Enter Item Name: Monitor
Enter Item Price: 4999.99
Enter Category ID: 10
Enter Category Name: Electronics */