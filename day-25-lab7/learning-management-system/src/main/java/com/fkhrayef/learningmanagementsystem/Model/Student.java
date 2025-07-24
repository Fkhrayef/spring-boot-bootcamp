package com.fkhrayef.learningmanagementsystem.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    @NotEmpty(message = "ID cannot be null")
    private String id;
    @NotEmpty(message = "Name cannot be null")
    private String name;
    @Email(message = "Invalid Email")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@sm\\.imamu\\.edu\\.sa$", message = "Email must be IMAMU address")
    private String email;
    @NotNull(message = "Level cannot be null")
    @PositiveOrZero(message = "Level must be positive")
    private Integer level;
    @NotEmpty(message = "Department cannot be null")
    @Pattern(regexp = "^(Computer Science|Business)$", message = "Department must be either Computer Science or Business")
    private String department;
    @NotNull(message = "GPA cannot be null")
    @Min(value = 0, message = "GPA cannot be negative")
    @Max(value = 5, message = "GPA cannot be greater than 5")
    private Double gpa;
}
