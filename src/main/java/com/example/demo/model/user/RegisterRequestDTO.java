package com.example.demo.model.user;

import lombok.Data;

@Data
public class RegisterRequestDTO {

    private String username;

    private String password;

    private String passwordConfirm;

    private String name;

    private String surname;

    private String carNumber;
}
