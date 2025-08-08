package com.example.restaurantproducer.service;

import com.example.restaurantproducer.model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class RestaurantService {

    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(1, "Pizza Place", "New York"));
        restaurants.add(new Restaurant(2, "Sushi Bar", "Tokyo"));
        restaurants.add(new Restaurant(3, "Burger House", "London"));
        return restaurants;
    }
}
