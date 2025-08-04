package com.fkhrayef.jobseekingsystem.Model;

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
@Check(constraints = "age >= 22")
@Check(constraints = "role IN ('JOB_SEEKER', 'EMPLOYER')")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name cannot be null")
    @Size(min = 5, max = 255, message = "Name must be between 5 and 255 characters")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Name must contain only letters and spaces")
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String name;

    @Email(message = "Email is not valid")
    @Column(columnDefinition = "VARCHAR(255) NOT NULL UNIQUE")
    private String email;

    @NotEmpty(message = "Password cannot be null")
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String password;

    @NotNull(message = "Age cannot be null")
    @Min(value = 22, message = "Age must be greater than 21")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer age;

    @NotEmpty(message = "Role cannot be null")
    @Pattern(regexp = "^(JOB_SEEKER|EMPLOYER)$", message = "Role must be either JOB_SEEKER or EMPLOYER")
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String role;
}
