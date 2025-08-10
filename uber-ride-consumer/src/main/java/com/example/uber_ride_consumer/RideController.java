package com.example.uber_ride_consumer;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rides")
public class RideController {

    private final RideRepository rideRepository;

    public RideController(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    @GetMapping
    public List<RideEntity> getAllRides() {
        return rideRepository.findAll();
    }

    @GetMapping("/{id}")
    public RideEntity getRide(@PathVariable Long id) {
        return rideRepository.findById(id).orElse(null);
    }
}
