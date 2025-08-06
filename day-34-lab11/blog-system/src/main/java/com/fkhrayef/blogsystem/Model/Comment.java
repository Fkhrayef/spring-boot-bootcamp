package com.fkhrayef.blogsystem.Model;

// Comment
//• comment_id
//• user_id
//• post_id
//• content
//• comment_date

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
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "content cannot be null")
    @Size(max = 255, message = "content must be less than 256 characters")
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String content;

    @Column(columnDefinition = "DATE NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private LocalDate commentDate;

    @NotNull(message = "user_id cannot be null")
    @Column(columnDefinition = "INTEGER NOT NULL")
    private Integer userId;

    @NotNull(message = "post_id cannot be null")
    @Column(columnDefinition = "INTEGER NOT NULL")
    private Integer postId;
}
