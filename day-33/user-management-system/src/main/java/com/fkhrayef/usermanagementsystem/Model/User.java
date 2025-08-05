package com.fkhrayef.usermanagementsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Check(constraints = "LENGTH(name) >= 5")
@Check(constraints = "role IN ('ADMIN', 'USER')")
@Check(constraints = "age >= 0")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name cannot be null")
    @Size(min = 5, max = 20, message = "Name must be between 5 and 20 characters")
    @Column(columnDefinition = "VARCHAR(20) NOT NULL")
    private String name;

    @NotEmpty(message = "Username cannot be null")
    @Size(min = 5, max = 20, message = "Name must be between 5 and 20 characters")
    @Column(columnDefinition = "VARCHAR(20) NOT NULL UNIQUE")
    private String username;

    @NotEmpty(message = "Password cannot be null")
    @Column(columnDefinition = "TEXT NOT NULL")
    private String password;

    @NotEmpty(message = "Email cannot be null")
    @Email(message = "Email is not valid")
    @Column(columnDefinition = "TEXT NOT NULL UNIQUE")
    private String email;

    @NotEmpty(message = "Role cannot be null")
    @Pattern(regexp = "^(ADMIN|USER)$", message = "Role must be either ADMIN or USER")
    @Column(columnDefinition = "TEXT NOT NULL")
    private String role;

    @NotNull(message = "Age cannot be null")
    @PositiveOrZero(message = "Age must be greater than or equal to zero")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer age;
}
