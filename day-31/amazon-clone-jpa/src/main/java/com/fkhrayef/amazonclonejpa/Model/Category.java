package com.fkhrayef.amazonclonejpa.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Check(name = "name_min", constraints = "LENGTH(name) >= 4")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Category name cannot be null")
    @Size(min = 4, max = 255, message = "Category name must be more than 3 characters and less than 256 characters")
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String name;
}
