package com.tester.demo.service;

import com.tester.demo.model.Category;
import com.tester.demo.storage.CategoryStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryStorage categoryStorage;

    public Category getCategoryById(Integer id) {
        return categoryStorage.getCategoryById(id);
    }

    public Category addCategory(Category category) {
        return categoryStorage.addCategory(category);
    }

    public Collection<Category> getCategories() {
        return categoryStorage.getCategories();
    }
}
