package assignment3;


public class Product {
    private Long id;
    private String name;
    private String category;
    private Double price;

    // Constructor
    public Product(Long id, String name, String category, Double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    // Setter
    public void setPrice(Double price) {
        this.price = price;
    }

    // toString method
    @Override
    public String toString() {
        return name + " (" + category + ", ₹" + price + ")";
    }
}