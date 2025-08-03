package com.fkhrayef.amazonclonejpa.Model;

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
@Check(name = "name_min", constraints = "LENGTH(username) >= 6")
@Check(name = "valid_role", constraints = "role IN ('Admin', 'Customer')")
@Check(name = "balance_positive", constraints = "balance > 0")
@Check(name = "valid_country", constraints = "country IN ('Saudi Arabia', 'Kuwait')")
@Check(name = "loyalty_points_positive_or_zero", constraints = "loyalty_points >= 0")
@Check(name = "total_carbon_footprint_positive_or_zero", constraints = "total_carbon_footprint >= 0")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "User username cannot be null")
    @Size(min = 6, max = 255, message = "User username must be more than 5 characters and less than 256 characters")
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String username;

    @NotEmpty(message = "User password cannot be null")
    @Pattern(
            regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{7,}$",
            message = "Password must be more than 6 characters long and include both letters and digits"
    )
    @Size(max = 255, message = "User password must be less than 256 characters")
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String password;

    @Email(message = "User email must be in a valid format")
    @Size(max = 255, message = "User email must be less than 256 characters")
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String email;

    @NotEmpty(message = "User role cannot be null")
    @Pattern(regexp = "^(Admin|Customer)$", message = "User role must be either 'Admin' or 'Customer'")
    @Column(columnDefinition = "VARCHAR(8) NOT NULL")
    private String role;

    @NotNull(message = "User balance cannot be null")
    @Positive(message = "User balance must be positive")
    @Column(columnDefinition = "DOUBLE NOT NULL")
    private Double balance;

    // extra
    @NotEmpty(message = "User country cannot be null")
    @Pattern(regexp = "^(Saudi Arabia|Kuwait)$", message = "Country must be either 'Saudi Arabia' or 'Kuwait'")
    @Column(columnDefinition = "VARCHAR(12) NOT NULL")
    private String country;

    @PositiveOrZero(message = "Loyalty points cannot be negative")
    @Column(name = "loyalty_points", columnDefinition = "INT DEFAULT 0")
    private Integer loyaltyPoints;

    @PositiveOrZero(message = "Total carbon footprint cannot be negative")
    @Column(name = "total_carbon_footprint", columnDefinition = "DOUBLE DEFAULT 0")
    private Double totalCarbonFootprint; // Total kg CO2 from all purchases
}
