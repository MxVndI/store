package com.tester.demo.service;

import com.tester.demo.model.cart.Cart;
import com.tester.demo.model.cart.CartItem;
import com.tester.demo.storage.CartStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartStorage cartStorage;

    public Cart createCart(Cart cart) {
        return cartStorage.addCart(cart);
    }

    public Cart getCartByUserId(Integer userId) {
        return cartStorage.getCartByUserId(userId);
    }

    public CartItem getCartItemByUserId(Integer userId) {
        return cartStorage.getCartItemByUserId(userId);
    }

    public List<Cart> getCarts() {
        return cartStorage.getCarts();
    }

    public Cart addItemToCart(Cart cart, Integer itemId, Integer itemCount) {
        return cartStorage.addItemToCart(cart, itemId, itemCount);
    }
}
