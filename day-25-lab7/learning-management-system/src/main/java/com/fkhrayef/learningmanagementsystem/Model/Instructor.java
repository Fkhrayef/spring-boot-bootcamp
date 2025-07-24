package com.fkhrayef.learningmanagementsystem.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Instructor {
    @NotEmpty(message = "ID cannot be null")
    private String id;
    @NotEmpty(message = "Name cannot be null")
    private String name;
    @Email(message = "Invalid Email")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@sm\\.imamu\\.edu\\.sa$", message = "Email must be IMAMU address")
    private String email;
    @NotEmpty(message = "Rank cannot be null")
    @Pattern(regexp = "^(Professor|Lecturer)$", message = "Rank must be either Professor or Lecturer")
    private String rank;
    @NotEmpty(message = "Specialization cannot be null")
    @Pattern(regexp = "^(AI|Networks)$", message = "Specialization must be either AI or Networks")
    private String specialization;
    @NotEmpty(message = "Department cannot be null")
    @Pattern(regexp = "^(Computer Science|Business)$", message = "Department must be either Computer Science or Business")
    private String department;
}
