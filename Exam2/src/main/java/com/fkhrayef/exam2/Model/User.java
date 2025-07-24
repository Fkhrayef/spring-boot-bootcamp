package com.fkhrayef.exam2.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    @NotEmpty(message = "ID cannot be null")
    private String id;
    @NotEmpty(message = "Name cannot be null")
    private String name;
    @NotNull(message = "Age cannot be null")
    private Integer age;
    @NotNull(message = "Balance cannot be null")
    @PositiveOrZero(message = "Balance cannot be negative")
    private Double balance;
    @NotEmpty(message = "Category cannot be null")
    @Pattern(regexp = "^(customer|librarian)$", message = "Role must be either customer or librarian")
    private String role;
}
