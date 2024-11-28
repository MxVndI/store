package com.tester.demo.controller;

import com.tester.demo.model.Category;
import com.tester.demo.model.Item;
import com.tester.demo.service.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("store/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    private final CategoryController categoryController;

    @GetMapping("/{id}")
    public Item getItem(@PathVariable("id") Integer id) {
        return itemService.getItemById(id);
    }

    @GetMapping
    public Collection<Item> getItems() {
        return itemService.getItems();
    }

    @PostMapping
    public Item addItem(@RequestBody @Valid Item item) {
        Set<Category> categories = new HashSet<>();
        for (Category category : item.getCategories()) {
            categories.add(categoryController.getCategoryById(category.getId()));
        }
        item.setCategories(categories);
        return itemService.addItem(item);
    }
}
