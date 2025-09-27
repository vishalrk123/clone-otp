package com.manpur.minute_bazar.controller;

import com.manpur.minute_bazar.model.Cart;
import com.manpur.minute_bazar.request.AddToCartRequest;
import com.manpur.minute_bazar.response.CartResponse;
import com.manpur.minute_bazar.service.CartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public CartResponse addToCart(@RequestBody AddToCartRequest request) {
        return cartService.addToCart(request);
    }

    @GetMapping("/{userId}")
    public Cart getCart(@PathVariable long userId) {
        System.out.println("vishal" + userId);
        return cartService.getCartByUserId(userId);
    }
}
