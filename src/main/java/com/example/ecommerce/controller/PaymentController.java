package com.example.ecommerce.controller;

import com.example.ecommerce.model.Payment;
import com.example.ecommerce.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Payment create(@RequestBody Map<String, Object> request) {

        String orderId = request.get("orderId").toString();
        double amount = Double.parseDouble(request.get("amount").toString());

        return service.createPayment(orderId, amount);
    }
}
