package com.tester.demo.controller;

import com.tester.demo.model.Category;
import com.tester.demo.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("store/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable("id") Integer id) {
        return categoryService.getCategoryById(id);
    }

    @GetMapping
    public Collection<Category> getCategories() {
        return categoryService.getCategories();
    }

    @PostMapping
    public Category addCategory(@RequestBody @Valid Category category) {
        return categoryService.addCategory(category);
    }
}
