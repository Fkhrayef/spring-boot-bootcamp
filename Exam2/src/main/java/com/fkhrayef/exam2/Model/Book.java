package com.fkhrayef.exam2.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    @NotEmpty(message = "ID cannot be null")
    private String id;
    @NotEmpty(message = "Name cannot be null")
    private String name;
    @NotNull(message = "Number of pages cannot be null")
    @PositiveOrZero(message = "Number of pages cannot be negative")
    private Integer numberOfPages;
    @NotNull(message = "Price cannot be null")
    @PositiveOrZero(message = "Price cannot be negative")
    private Double price;
    @NotEmpty(message = "Category cannot be null")
    @Pattern(regexp = "^(novel|academic)$", message = "Category must be either novel or academic")
    private String category;
    @NotNull(message = "Availability cannot be null")
    private Boolean isAvailable;
}
