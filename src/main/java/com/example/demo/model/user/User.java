package com.example.demo.model.user;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class User {

    private Long id;

    private String username;

    private String name;

    private String surname;

    private String carNumber;

    private BigDecimal balance;

    private Set<Role> roles;

    private LocalDateTime profileCreated;
}
