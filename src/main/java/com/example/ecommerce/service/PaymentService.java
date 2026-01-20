package com.example.ecommerce.service;

import com.example.ecommerce.model.Order;
import com.example.ecommerce.model.Payment;
import com.example.ecommerce.repository.OrderRepository;
import com.example.ecommerce.repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepo;
    private final OrderRepository orderRepo;

    public PaymentService(PaymentRepository paymentRepo,
                          OrderRepository orderRepo) {
        this.paymentRepo = paymentRepo;
        this.orderRepo = orderRepo;
    }

    public Payment createPayment(String orderId, double amount) {

        Payment payment = new Payment();
        payment.setOrderId(orderId);
        payment.setAmount(amount);
        payment.setStatus("PENDING");

        Payment savedPayment = paymentRepo.save(payment);

        // 🔔 MOCK PAYMENT SUCCESS (after 2 seconds)
        new Thread(() -> {
            try {
                Thread.sleep(2000);

                savedPayment.setStatus("SUCCESS");
                paymentRepo.save(savedPayment);

                Order order = orderRepo.findById(orderId).orElseThrow();
                order.setStatus("PAID");
                orderRepo.save(order);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        return savedPayment;
    }
}
