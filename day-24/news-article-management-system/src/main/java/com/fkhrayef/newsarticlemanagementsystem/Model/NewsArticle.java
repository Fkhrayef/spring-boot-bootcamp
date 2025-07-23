package com.fkhrayef.newsarticlemanagementsystem.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class NewsArticle {
    @NotEmpty(message = "ID cannot be null")
    private String id;

    @NotEmpty(message = "Title cannot be null")
    @Size(max = 100, message = "Title must not exceed 100 characters")
    private String title;

    @NotEmpty(message = "Author cannot be null")
    @Size(min = 4, max = 20, message = "Author must be between 4 and 20 characters")
    private String author;

    @NotEmpty(message = "Content cannot be null")
    @Size(min = 200, message = "Content must be more than 200 characters")
    private String content;

    @NotEmpty(message = "Category cannot be null")
    @Pattern(regexp = "^(politics|sports|technology)$")
    private String category;

    @NotEmpty(message = "Image URL cannot be null")
    private String imageUrl;

    private Boolean isPublished;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate publishDate;
}
