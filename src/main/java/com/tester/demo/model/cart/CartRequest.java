package com.tester.demo.model.cart;

import lombok.Data;

@Data
public class CartRequest {
    private Integer itemId;
    private Integer itemCount;
}
