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
@Check(name = "stock_positive", constraints = "stock > 0")
public class MerchantStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "MerchantStock must have a product id")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer productId;

    @NotNull(message = "MerchantStock must have a merchant id")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer merchantId;

    @NotNull(message = "MerchantStock stock cannot be null")
    @Positive(message = "MerchantStock stock must be positive")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer stock; // initially 10 (Logically implemented in service)

    // extra
    @Pattern(regexp = "^[a-zA-Z]{4}-\\d{1,2}$") // 4 letters then '-' then discount count
    private String coupon;
}

