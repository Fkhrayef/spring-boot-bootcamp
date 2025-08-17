package com.fkhrayef.schoolmanagementsystem.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    @NotNull(message = "Teacher id is required")
    private Integer teacherId;

    @NotEmpty(message = "Area is required")
    private String area;

    @NotEmpty(message = "Street is required")
    private String street;

    @NotEmpty(message = "Building number is required")
    private String buildingNumber;
}
