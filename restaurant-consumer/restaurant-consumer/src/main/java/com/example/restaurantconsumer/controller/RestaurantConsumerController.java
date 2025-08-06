package com.example.restaurantconsumer.controller;

import com.example.restaurantconsumer.model.Restaurant;
import com.example.restaurantconsumer.service.RestaurantClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumer")  // Base path for Consumer API
public class RestaurantConsumerController {

    @Autowired
    private RestaurantClient restaurantClient;  // Feign client to call Producer

    // GET http://localhost:8082/consumer/restaurants
    @GetMapping("/restaurants")
    public List<Restaurant> getAllRestaurants() {
        // Calls Producer service via Feign client
        return restaurantClient.getAllRestaurants();
    }
}
