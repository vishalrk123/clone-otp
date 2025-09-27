package com.manpur.minute_bazar.serviceImpl;

import com.manpur.minute_bazar.model.Cart;
import com.manpur.minute_bazar.model.CartItem;
import com.manpur.minute_bazar.repository.CartItemRepository;
import com.manpur.minute_bazar.repository.CartRepository;
import com.manpur.minute_bazar.request.AddToCartRequest;
import com.manpur.minute_bazar.response.CartItemResponse;
import com.manpur.minute_bazar.response.CartResponse;
import com.manpur.minute_bazar.service.CartService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    @Override
    public CartResponse addToCart(AddToCartRequest request) {
        // your business logic
        Cart cart = getCartByUserId(request.getUserId());
//        System.out.println("rahul1" + " " + cart.toString());

        cart.getItems().add(CartItem.builder()
                .productId(request.getProductId())
                .quantity(request.getQuantity())
                .cart(cart).build());
  //     System.out.println("rahul2" + " " + );

        Cart updatedcart = cartRepository.save(cart);
//        System.out.println("rahul3" + " " + updatedcart.toString());
        return CartResponse.builder()
                .cartId(updatedcart.getId())
                .userId(updatedcart.getUserId())
                .items(updatedcart.getItems().stream().map(cartItem -> CartItemResponse.builder()
                        .productId(cartItem.getProductId())
                        .quantity(cartItem.getQuantity())
                        .build()).toList())
                .build();
    }

    @Override
    public Cart getCartByUserId(long userId) {
        // your business logic

        return cartRepository.findByUserId(userId);
    }
}
