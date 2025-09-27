package com.manpur.minute_bazar.convertor;

import com.manpur.minute_bazar.model.Cart;
import com.manpur.minute_bazar.model.CartItem;
import com.manpur.minute_bazar.response.CartItemResponse;
import com.manpur.minute_bazar.response.CartResponse;

import java.util.stream.Collectors;


public class CartConvertor {
    public static CartResponse toResponse(Cart cart) {
        CartResponse response = new CartResponse();
        response.setCartId(cart.getId());
        response.setUserId(cart.getUserId());
        response.setItems(
                cart.getItems().stream()
                        .map(CartConvertor::toItemResponse)
                        .collect(Collectors.toList())
        );
        return response;
    }

    public static CartItemResponse toItemResponse(CartItem item) {
        CartItemResponse response = new CartItemResponse();
        response.setProductId(item.getProductId());
        response.setQuantity(item.getQuantity());
        return response;
    }
}
