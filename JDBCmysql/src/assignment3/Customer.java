package assignment3;



public class Customer {
    private Long id;
    private String name;
    private Integer tier;

    // Constructor
    public Customer(Long id, String name, Integer tier) {
        this.id = id;
        this.name = name;
        this.tier = tier;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getTier() {
        return tier;
    }

    // toString method
    @Override
    public String toString() {
        return "Customer{id=" + id + ", name='" + name + "', tier=" + tier + "}";
    }
}