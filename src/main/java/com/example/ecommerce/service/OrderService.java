package com.example.ecommerce.service;

import com.example.ecommerce.model.*;
import com.example.ecommerce.repository.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepo;
    private final CartRepository cartRepo;
    private final ProductRepository productRepo;

    public OrderService(OrderRepository orderRepo,
                        CartRepository cartRepo,
                        ProductRepository productRepo) {
        this.orderRepo = orderRepo;
        this.cartRepo = cartRepo;
        this.productRepo = productRepo;
    }

    public Order placeOrder(String userId) {

        List<CartItem> cartItems = cartRepo.findByUserId(userId);

        List<OrderItem> orderItems = new ArrayList<>();
        double total = 0;

        for (CartItem cart : cartItems) {
            Product product = productRepo.findById(cart.getProductId()).orElseThrow();

            OrderItem item = new OrderItem();
            item.setProductId(product.getId());
            item.setQuantity(cart.getQuantity());
            item.setPrice(product.getPrice());

            orderItems.add(item);
            total += product.getPrice() * cart.getQuantity();
        }

        Order order = new Order();
        order.setUserId(userId);
        order.setItems(orderItems);
        order.setTotalAmount(total);
        order.setStatus("CREATED");

        Order savedOrder = orderRepo.save(order);

        // ✅ clear cart after order
        cartRepo.deleteByUserId(userId);

        return savedOrder;
    }

    public Order get(String id) {
        return orderRepo.findById(id).orElse(null);
    }
}
