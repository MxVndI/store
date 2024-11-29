package com.tester.demo.model.cart;

import com.tester.demo.model.Item;
import lombok.Data;

import java.util.Map;

@Data
public class CartItemAnswer {
    Map<Item, Integer> itemsCount;
}
