package com.tester.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "items")
@ToString
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "item_category",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();
    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull
    private Integer price;
    private String image;
}
