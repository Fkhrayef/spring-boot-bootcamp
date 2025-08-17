package com.fkhrayef.schoolmanagementsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import org.hibernate.annotations.Check;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Check(constraints = "age >= 0")
@Check(constraints = "salary >= 0")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Teacher name is required")
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String name;

    @NotNull(message = "Teacher age is required")
    @PositiveOrZero(message = "Teacher age must be positive or zero")
    @Column(columnDefinition = "INTEGER NOT NULL")
    private Integer age;

    @Email(message = "Teacher email is not valid")
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String email;

    @NotNull(message = "Teacher salary is required")
    @PositiveOrZero(message = "Teacher salary must be positive or zero")
    @Column(columnDefinition = "DOUBLE NOT NULL")
    private Double salary;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private Set<Course> courses;
}
