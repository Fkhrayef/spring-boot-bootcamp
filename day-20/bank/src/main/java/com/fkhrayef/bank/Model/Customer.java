package com.fkhrayef.bank.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    private int id;
    private String username;
    private double balance;
}

