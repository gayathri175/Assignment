package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Scanner;

public class MainApp2 {
    public static void main(String[] args) {
        // Use renamed config class: CollegeConfig
        ApplicationContext context = new AnnotationConfigApplicationContext(CollegeConfig.class);

        Scanner sc = new Scanner(System.in);
        System.out.println("====== AUTOWIRED ANNOTATION DEMO ======");
        System.out.println("Options:");
        System.out.println("1. Autowired");
        System.out.println("2. Autowired with Qualifier");
        System.out.print("Select option: ");
        int choice = sc.nextInt();

        // Get Freshman bean from Spring container
        Freshman freshman = context.getBean(Freshman.class);

        if (choice == 1) {
            System.out.println("\n>>> Autowired without Qualifier (by type)");
            System.out.println("⚠️ Make sure @Qualifier is removed or commented in Freshman.java to test this.");
        } else if (choice == 2) {
            System.out.println("\n>>> Autowired with Qualifier (using @Qualifier(\"dormRoom2\"))");
        } else {
            System.out.println("Invalid option.");
            return;
        }

        // Display freshman's details
        System.out.println("\nStudent Details:");
        freshman.printDetails();
    }
}
