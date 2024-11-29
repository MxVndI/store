package com.tester.demo.storage;

import com.tester.demo.model.cart.Cart;
import com.tester.demo.model.cart.CartItem;
import com.tester.demo.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CartStorage {
    private final CartRepository cartRepository;
    private final CartItemStorage cartItemStorage;
    private final ItemStorage itemStorage;

    public Cart addCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public CartItem getCartItemByUserId(Integer userId) {
        Cart cart = cartRepository.findByUserId(userId);
        return cartItemStorage.getCartByCartId(cart.getId());
    }

    public Cart getCartByUserId(Integer userId) {
        return cartRepository.findByUserId(userId);
    }

    public List<Cart> getCarts() {
        return cartRepository.findAll();
    }

    public Cart addItemToCart(Cart cart, Integer itemId, Integer itemCount) {
        CartItem cartItem = new CartItem();
        cartItem.setItem(itemStorage.getItemById(itemId));
        cartItem.setItemCount(itemCount);
        cartItem.setCart(cart);
        cartItemStorage.addCartItem(cartItem);
        return cartRepository.save(cart);
    }
}
