package com.tester.demo.repository;

import com.tester.demo.model.cart.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

    CartItem findByCartId(Integer cartId);

    List<CartItem> findAllByCartId(Integer cartId);
}
