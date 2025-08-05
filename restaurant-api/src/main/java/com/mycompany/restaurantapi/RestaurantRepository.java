package com.mycompany.restaurantapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {}

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {}
