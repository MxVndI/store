package com.tester.demo.storage;

import com.tester.demo.model.Category;
import com.tester.demo.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RequiredArgsConstructor
public class CategoryStorage {
    private final CategoryRepository categoryRepository;

    public Category getCategoryById(Integer categoryId) {
        return categoryRepository.findById(categoryId).get();
    }

    public Category addCategory(Category category) {
        categoryRepository.save(category);
        return category;
    }

    public Collection<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public void deleteCategoryById(Integer categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    public Integer getCategoryByName(String name) {
        System.out.println(name);
        System.out.println(categoryRepository.findByNameLike(name));
       return categoryRepository.findByNameLike(name).getId();
    }
}
