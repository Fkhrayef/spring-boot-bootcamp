package com.fkhrayef.employeemanagementsystem.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Employee {
    @NotEmpty(message = "ID cannot be null")
    @Size(min = 3, message = "ID length must be more than 2 characters")
    private String id;

    @NotEmpty(message = "Name cannot be null")
    @Size(min = 5, message = "Name must be more than 4 characters")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Name must only contain characters")
    private String name;

    @Email
    private String email;

    @Pattern(regexp = "^05\\d*$", message = "Phone number must start with 05")
    @Size(min = 10, max = 10, message = "Phone number must be 10 digits")
    private String phoneNumber;

    @NotNull(message = "Age cannot be null")
    @Positive(message = "Age must be a positive number")
    @Min(value = 26, message = "Age must be older than 25")
    private Integer age;

    @NotEmpty(message = "Position cannot be null")
    @Pattern(regexp = "^(supervisor|coordinator)$", message = "Position must be either supervisor or coordinator")
    private String position;

    // must initially be false (I'll do that in addEmployee())
    private Boolean onLeave;

    @NotNull(message = "Hire date cannot be null")
    @PastOrPresent(message = "Hire date must be in the present or the past")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate hireDate;

    @NotNull(message = "Annual leave cannot be null")
    @Positive(message = "Annual leave value must be positive")
    private Integer annualLeave;
}
