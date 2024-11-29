package com.tester.demo.storage;

import com.tester.demo.model.Item;
import com.tester.demo.model.cart.Cart;
import com.tester.demo.model.cart.CartItem;
import com.tester.demo.model.cart.CartItemAnswer;
import com.tester.demo.repository.CartItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CartItemStorage {
    private final CartItemRepository cartItemRepository;
    private final ItemStorage itemStorage;

    public CartItem addCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    public CartItem getCartByCartId(Integer cartId) {
        return cartItemRepository.findByCartId(cartId);
    }

    public List<CartItem> getCarts() {
        return cartItemRepository.findAll();
    }

    public Cart updateCart(Cart cart) {
        return cart;
    }

    public CartItemAnswer getItemsCount(Integer cartId) {
        List<CartItem> cartItems =  cartItemRepository.findAllByCartId(cartId);
        HashMap<Item, Integer> itemCount = new HashMap<>();
        for (CartItem cartItem: cartItems) {
            Item item = itemStorage.getItemById(cartItem.getItem().getId());
            itemCount.put(item, cartItem.getItemCount());
        }
        CartItemAnswer cartItemAnswer = new CartItemAnswer();
        cartItemAnswer.setItemsCount(itemCount);
        return cartItemAnswer;
    }
}
