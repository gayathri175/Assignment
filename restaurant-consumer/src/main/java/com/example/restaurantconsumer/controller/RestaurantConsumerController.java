package com.example.restaurantconsumer.controller;

import com.example.restaurantconsumer.model.Restaurant;
import com.example.restaurantconsumer.service.RestaurantClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class RestaurantConsumerController {

    @Autowired
    private RestaurantClient restaurantClient;

    @GetMapping("/restaurants")
    public List<Restaurant> getAllRestaurants() {
        return restaurantClient.getAllRestaurants();
    }
}
