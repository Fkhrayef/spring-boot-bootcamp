package com.fkhrayef.blogsystem.Model;

// category_id
//• name

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Category name cannot be null")
    @Column(columnDefinition = "TEXT NOT NULL UNIQUE")
    private String name;
}
