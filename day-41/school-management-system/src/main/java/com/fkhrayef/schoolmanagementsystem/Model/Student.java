package com.fkhrayef.schoolmanagementsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Check(constraints = "age >= 0")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Student name cannot be null")
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String name;

    @NotNull(message = "Student age cannot be null")
    @PositiveOrZero(message = "Student age must be positive or zero")
    @Column(columnDefinition = "INTEGER NOT NULL")
    private Integer age;

    @NotEmpty(message = "Student major cannot be null")
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String major;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;
}
