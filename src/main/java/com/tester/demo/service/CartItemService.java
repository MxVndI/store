package com.tester.demo.service;

import com.tester.demo.model.cart.Cart;
import com.tester.demo.model.cart.CartItem;
import com.tester.demo.model.cart.CartItemAnswer;
import com.tester.demo.storage.CartItemStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartItemService {
    private final CartItemStorage cartItemStorage;

    public CartItem createCartItem(CartItem cartItem) {
        return cartItemStorage.addCartItem(cartItem);
    }

    public CartItem getCartItemByCartId(Integer cartId) {
        return cartItemStorage.getCartByCartId(cartId);
    }

    public List<CartItem> getCartItems() {
        return cartItemStorage.getCarts();
    }

    public CartItemAnswer getItemsCount(Integer cartId) {
        return cartItemStorage.getItemsCount(cartId);
    }
}
