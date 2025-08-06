package com.fkhrayef.blogsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Username cannot be null")
    @Column(columnDefinition = "TEXT NOT NULL UNIQUE")
    private String username;

    @NotEmpty(message = "Password cannot be null")
    @Column(columnDefinition = "TEXT NOT NULL")
    private String password;

    @NotEmpty(message = "Email cannot be null")
    @Email(message = "Email is not valid")
    @Column(columnDefinition = "TEXT NOT NULL UNIQUE")
    private String email;

    @Column(columnDefinition = "DATE NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private LocalDate registrationDate;
}
