package com.tester.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "items")
@ToString(exclude = "categories")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "item_categories",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;
    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull
    private Integer price;
    private String image;
    private Integer count;

}
