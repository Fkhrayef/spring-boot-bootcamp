package com.fkhrayef.project.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Project {
    private int id;
    private String title;
    private String description;
    private String status;
    private String companyName;
}
