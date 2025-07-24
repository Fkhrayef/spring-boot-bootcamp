package com.fkhrayef.learningmanagementsystem.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Course {
    @NotEmpty(message = "ID cannot be null")
    private String id;
    @NotEmpty(message = "Title cannot be null")
    private String title;
    @NotEmpty(message = "Description cannot be null")
    private String description;
    @NotEmpty(message = "Instructor cannot be null")
    private String instructor;
    @NotEmpty(message = "Difficulty cannot be null")
    @Pattern(regexp = "^(Easy|Hard)$", message = "Difficulty must be either Easy or Hard")
    private String difficulty;
    @NotEmpty(message = "Department cannot be null")
    @Pattern(regexp = "^(Computer Science|Business)$", message = "Department must be either Computer Science or Business")
    private String department;
}
