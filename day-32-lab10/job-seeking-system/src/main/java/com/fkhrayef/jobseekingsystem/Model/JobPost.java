package com.fkhrayef.jobseekingsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Check(constraints = "LENGTH(title) >= 5")
@Check(constraints = "salary >= 0")
public class JobPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Title cannot be null")
    @Size(min = 5, max = 255, message = "Title must be between 5 and 255 characters")
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String title;

    @NotEmpty(message = "Description cannot be null")
    @Column(columnDefinition = "TEXT NOT NULL")
    private String description;

    @NotEmpty(message = "Location cannot be null")
    @Size(max = 255, message = "Location must be less than 256 characters")
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String location;

    @NotNull(message = "Salary cannot be null")
    @PositiveOrZero(message = "Salary cannot be negative")
    @Column(columnDefinition = "DOUBLE NOT NULL")
    private Double salary;

    @Column(columnDefinition = "DATE NOT NULL DEFAULT CURRENT_DATE")
    private LocalDate postingDate;
}
