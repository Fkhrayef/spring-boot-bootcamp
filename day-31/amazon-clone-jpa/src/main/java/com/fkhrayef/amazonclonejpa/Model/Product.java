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
@Check(name = "name_min", constraints = "LENGTH(name) >= 4")
@Check(name = "price_positive", constraints = "price > 0")
@Check(name = "saudi_buy_count_positive_or_zero", constraints = "saudi_buy_count >= 0")
@Check(name = "kuwait_buy_count_positive_or_zero", constraints = "kuwait_buy_count >= 0")
@Check(name = "view_count_positive_or_zero", constraints = "view_count >= 0")
@Check(name = "carbon_foot_print_positive_or_zero", constraints = "carbon_foot_print >= 0")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Product name cannot be null")
    @Size(min = 4, max = 255, message = "Product name must be more than 3 characters and less than 256 characters")
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String name;

    @NotNull(message = "Product price cannot be null")
    @Positive(message = "Product price must be positive")
    @Column(columnDefinition = "DOUBLE NOT NULL")
    private Double price;

    @NotNull(message = "Product must have a category id")
    private Integer categoryId;

    //extra
    @PositiveOrZero(message = "Saudi buy count cannot be negative")
    @Column(name = "saudi_buy_count", columnDefinition = "INT DEFAULT 0")
    private Integer saudiBuyCount;

    @PositiveOrZero(message = "Kuwait buy count cannot be negative")
    @Column(name = "kuwait_buy_count",columnDefinition = "INT DEFAULT 0")
    private Integer kuwaitBuyCount;

    @PositiveOrZero(message = "View count cannot be negative")
    @Column(name = "view_count",columnDefinition = "INT DEFAULT 0")
    private Integer viewCount;

    @NotNull(message = "Product carbon footprint cannot be null")
    @PositiveOrZero(message = "Carbon footprint cannot be negative")
    @Column(name = "carbon_foot_print", columnDefinition = "DOUBLE NOT NULL")
    private Double carbonFootprint; // kg CO2 per product
}
