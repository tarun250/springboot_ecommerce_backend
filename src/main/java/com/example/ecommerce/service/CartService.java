package com.example.ecommerce.service;

import com.example.ecommerce.model.CartItem;
import com.example.ecommerce.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository repo;

    public CartService(CartRepository repo) {
        this.repo = repo;
    }

    public CartItem addToCart(CartItem item) {
        return repo.save(item);
    }

    public List<CartItem> getUserCart(String userId) {
        return repo.findByUserId(userId);
    }

    public void clearCart(String userId) {
        repo.deleteByUserId(userId);
    }
}
