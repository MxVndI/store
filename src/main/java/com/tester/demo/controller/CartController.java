package com.tester.demo.controller;

import com.tester.demo.model.cart.Cart;
import com.tester.demo.model.cart.CartItem;
import com.tester.demo.model.cart.CartItemAnswer;
import com.tester.demo.model.cart.CartRequest;
import com.tester.demo.service.CartItemService;
import com.tester.demo.service.CartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store/cart")
public class CartController {
    private final CartService cartService;
    private final CartItemService cartItemService;


    private Cart getCartByUserId(Integer userId) {
        return cartService.getCartByUserId(userId);
    }

    @GetMapping("/{userId}")
    public CartItemAnswer getCartItemByUserId(@PathVariable("userId") Integer userId) {
        CartItem cartItem = cartService.getCartItemByUserId(userId);
        System.out.println(cartItem.toString());
        return cartItemService.getItemsCount(cartItem.getId());
    }

    @GetMapping()
    public List<Cart> getCarts() {
        return cartService.getCarts();
    }

    @PostMapping()
    public Cart createCartForUser(@Valid Cart cart) {
        return cartService.createCart(cart);
    }

    @PostMapping("/{userId}")
    @Cacheable
    public Cart addItemToCart(@PathVariable("userId") Integer userId,
                              @RequestBody CartRequest request) {
        Cart cart = getCartByUserId(userId);
        if (cart != null) {
            return cartService.addItemToCart(cart, request.getItemId(), request.getItemCount());
        }
        return null;
    }
}
