package com.example.restaurantconsumer.service;

import com.example.restaurantconsumer.model.Restaurant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@FeignClient(name = "restaurant-producer")
public interface RestaurantClient {

    @GetMapping("/restaurants")
    List<Restaurant> getAllRestaurants();
}

