package com.fkhrayef.jobseekingsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "User ID cannot be null")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer userId;

    @NotNull(message = "Job post ID cannot be null")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer jobPostId;
}
