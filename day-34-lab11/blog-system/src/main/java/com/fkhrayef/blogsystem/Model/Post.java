package com.fkhrayef.blogsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "title cannot be null")
    @Size(max = 15, message = "title must be less than 16 characters")
    @Column(columnDefinition = "VARCHAR(15) NOT NULL")
    private String title;

    @NotEmpty(message = "content cannot be null")
    @Size(max = 1000, message = "content must be less than 1001 characters")
    @Column(columnDefinition = "VARCHAR(1000) NOT NULL")
    private String content;

    @Column(columnDefinition = "DATE NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private LocalDate publishDate;

    @NotNull(message = "user_id cannot be null")
    @Column(columnDefinition = "INTEGER NOT NULL")
    private Integer userId;

    @NotNull(message = "category_id cannot be null")
    @Column(columnDefinition = "INTEGER NOT NULL")
    private Integer categoryId;
}
