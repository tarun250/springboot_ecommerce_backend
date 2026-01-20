package com.example.ecommerce.controller;

import com.example.ecommerce.model.CartItem;
import com.example.ecommerce.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService service;

    public CartController(CartService service) {
        this.service = service;
    }

    // ✅ ADD TO CART
    @PostMapping("/add")
    public CartItem add(@RequestBody CartItem item) {
        return service.addToCart(item);
    }

    // ✅ GET USER CART
    @GetMapping("/{userId}")
    public List<CartItem> getCart(@PathVariable String userId) {
        return service.getUserCart(userId);
    }

    // ✅ CLEAR CART
    @DeleteMapping("/{userId}/clear")
    public String clear(@PathVariable String userId) {
        service.clearCart(userId);
        return "Cart cleared successfully";
    }
}
