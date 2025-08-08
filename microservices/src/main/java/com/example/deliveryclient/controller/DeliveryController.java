package com.example.deliveryclient.controller;

import com.example.deliveryclient.service.DeliveryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryController {

    private final DeliveryService service;

    public DeliveryController(DeliveryService service) {
        this.service = service;
    }

    @GetMapping("/check-status")
    public String checkDeliveryStatus() {
        return service.getDeliveryStatus();
    }
}
