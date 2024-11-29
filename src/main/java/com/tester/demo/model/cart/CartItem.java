package com.tester.demo.model.cart;

import com.tester.demo.model.Item;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "cart_item")
@Data
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Item item;
    private Integer itemCount;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
}
