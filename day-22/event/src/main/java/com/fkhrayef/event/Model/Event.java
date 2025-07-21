package com.fkhrayef.event.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Event {
    @NotEmpty(message = "ID cannot be null")
    @Size(min = 2, message = "ID must be at least 2 characters long")
    private String id;

    @NotEmpty(message = "Description cannot be null")
    @Size(min = 15, message = "Description must be at least 15 characters long")
    private String description;

    @NotNull(message = "Capacity cannot be null")
    @Min(value = 26, message = "Capacity must be greater than 25")
    private Integer capacity;

    @NotNull(message = "Start date cannot be null")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDate;

    @NotNull(message = "End date cannot be null")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDate;
}
