package com.manpur.minute_bazar.service;

import com.manpur.minute_bazar.model.Cart;
import com.manpur.minute_bazar.request.AddToCartRequest;
import com.manpur.minute_bazar.response.CartResponse;

public interface CartService {
    CartResponse addToCart(AddToCartRequest request);
    Cart getCartByUserId(long userId);
}
