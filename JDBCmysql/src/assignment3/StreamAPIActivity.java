package assignment3;


import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

public class StreamAPIActivity {
    public static void main(String[] args) {
        // Sample Products
        List<Product> products = List.of(
            new Product(1L, "Java Book", "Books", 250.0),
            new Product(2L, "Baby Diaper", "Baby", 75.0),
            new Product(3L, "Toy Car", "Toys", 150.0),
            new Product(4L, "C++ Book", "Books", 90.0),
            new Product(5L, "Soft Toy", "Toys", 200.0),
            new Product(6L, "Baby Powder", "Baby", 120.0),
            new Product(7L, "Python Book", "Books", 180.0)
        );

        // Sample Customers
        Customer cust1 = new Customer(101L, "Alice", 1);
        Customer cust2 = new Customer(102L, "Bob", 2);
        Customer cust3 = new Customer(103L, "Charlie", 2);

        // Sample Orders
        List<Order> orders = List.of(
            new Order(201L, "Shipped", LocalDate.of(2021, 2, 5), LocalDate.of(2021, 2, 10), List.of(products.get(0), products.get(1)), cust2),
            new Order(202L, "Delivered", LocalDate.of(2021, 3, 15), LocalDate.of(2021, 3, 18), List.of(products.get(2), products.get(3)), cust3),
            new Order(203L, "Pending", LocalDate.of(2021, 4, 1), LocalDate.of(2021, 4, 5), List.of(products.get(4)), cust1),
            new Order(204L, "Delivered", LocalDate.of(2021, 2, 20), LocalDate.of(2021, 2, 25), List.of(products.get(6), products.get(5)), cust2)
        );

        // 1. Books with price > 100
        System.out.println("\n1. Books with price > 100:");
        products.stream()
            .filter(p -> p.getCategory().equalsIgnoreCase("Books") && p.getPrice() > 100)
            .forEach(System.out::println);

        // 2. Orders with Baby products
        System.out.println("\n2. Orders with at least one Baby product:");
        orders.stream()
            .filter(o -> o.getProducts().stream().anyMatch(p -> p.getCategory().equalsIgnoreCase("Baby")))
            .forEach(System.out::println);

        // 3. Toys with 10% discount
        System.out.println("\n3. Toys after 10% discount:");
        products.stream()
            .filter(p -> p.getCategory().equalsIgnoreCase("Toys"))
            .map(p -> new Product(p.getId(), p.getName(), p.getCategory(), p.getPrice() * 0.9))
            .forEach(System.out::println);

        // 4. Products ordered by tier 2 customers between 01-Feb-2021 and 01-Apr-2021
        System.out.println("\n4. Products ordered by Tier 2 customers between Feb–Apr 2021:");
        orders.stream()
            .filter(o -> o.getCustomer().getTier() == 2)
            .filter(o -> !o.getOrderDate().isBefore(LocalDate.of(2021, 2, 1)) &&
                         !o.getOrderDate().isAfter(LocalDate.of(2021, 4, 1)))
            .flatMap(o -> o.getProducts().stream())
            .distinct()
            .forEach(System.out::println);

        // 5. Cheapest Book
        System.out.println("\n5. Cheapest book:");
        products.stream()
            .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
            .min(Comparator.comparing(Product::getPrice))
            .ifPresent(System.out::println);

        // 6. 3 Most recent orders
        System.out.println("\n6. 3 most recent orders:");
        orders.stream()
            .sorted(Comparator.comparing(Order::getOrderDate).reversed())
            .limit(3)
            .forEach(System.out::println);

        // 7. Total sum of orders placed in Feb 2021
        System.out.println("\n7. Total sum of orders in Feb 2021:");
        double total = orders.stream()
            .filter(o -> o.getOrderDate().getMonthValue() == 2 && o.getOrderDate().getYear() == 2021)
            .flatMap(o -> o.getProducts().stream())
            .mapToDouble(Product::getPrice)
            .sum();
        System.out.println("₹" + total);

        // 8. Summary stats for Books
        System.out.println("\n8. Summary statistics for Books:");
        DoubleSummaryStatistics stats = products.stream()
            .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
            .mapToDouble(Product::getPrice)
            .summaryStatistics();
        System.out.println(stats);

        // 9. Most expensive product by category
        System.out.println("\n9. Most expensive product by category:");
        Map<String, Optional<Product>> expensiveByCategory = products.stream()
            .collect(Collectors.groupingBy(
                Product::getCategory,
                Collectors.maxBy(Comparator.comparing(Product::getPrice))
            ));

        expensiveByCategory.forEach((category, product) -> {
            System.out.println(category + " => " + product.orElse(null));
        });
    }
}