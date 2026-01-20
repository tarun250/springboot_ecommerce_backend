package com.example.ecommerce.controller;

import com.example.ecommerce.model.Order;
import com.example.ecommerce.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    // ✅ CREATE ORDER FROM CART
    @PostMapping
    public Order place(@RequestBody Order request) {
        return service.placeOrder(request.getUserId());
    }

    // ✅ GET ORDER BY ID
    @GetMapping("/{id}")
    public Order get(@PathVariable String id) {
        return service.get(id);
    }
}
