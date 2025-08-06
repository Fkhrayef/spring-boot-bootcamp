package com.fkhrayef.blogsystem.Service;

import com.fkhrayef.blogsystem.Api.ApiException;
import com.fkhrayef.blogsystem.Model.Category;
import com.fkhrayef.blogsystem.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public void addCategory(Category category) {
        if (categoryRepository.findCategoryByName(category.getName()) != null) {
            throw new ApiException("Category already exists");
        }
        categoryRepository.save(category);
    }

    public void updateCategory(Integer id, Category category) {
        Category oldCategory = categoryRepository.findCategoryById(id);
        if (oldCategory == null) {
            throw new ApiException("Category not found");
        }
        if (categoryRepository.findCategoryByName(category.getName()) != null && !oldCategory.getName().equals(category.getName())) {
            throw new ApiException("Category already exists");
        }
        oldCategory.setName(category.getName());
        categoryRepository.save(oldCategory);
    }

    public void deleteCategory(Integer id) {
        Category oldCategory = categoryRepository.findCategoryById(id);
        if (oldCategory == null) {
            throw new ApiException("Category not found");
        }
        categoryRepository.delete(oldCategory);
    }

    public Category getCategoryByName(String name) {
        Category category = categoryRepository.findCategoryByName(name);
        if (category == null) {
            throw new ApiException("Category not found");
        }
        return category;
    }
}
