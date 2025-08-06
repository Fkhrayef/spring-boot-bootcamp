package com.fkhrayef.blogsystem.Controller;

import com.fkhrayef.blogsystem.Api.ApiResponse;
import com.fkhrayef.blogsystem.Model.Category;
import com.fkhrayef.blogsystem.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/get")
    public ResponseEntity<?> getAllCategories() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getAllCategories());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCategory(@Valid @RequestBody Category category, Errors errors) {
        if (errors.hasErrors()) {
            ArrayList<String> errorMessages = new ArrayList<>();
            for (FieldError error : errors.getFieldErrors()) {
                errorMessages.add(error.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
        }

        categoryService.addCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Category added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable("id") Integer id, @Valid @RequestBody Category category, Errors errors) {
        if (errors.hasErrors()) {
            ArrayList<String> errorMessages = new ArrayList<>();
            for (FieldError error : errors.getFieldErrors()) {
                errorMessages.add(error.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
        }
        categoryService.updateCategory(id, category);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Category updated successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") Integer id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // searches category by name
    @GetMapping("/get/name/{name}")
    public ResponseEntity<?> getCategoryByName(@PathVariable("name") String name) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getCategoryByName(name));
    }
}
