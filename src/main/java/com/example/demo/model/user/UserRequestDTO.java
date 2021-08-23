package com.example.demo.model.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRequestDTO {

    private String username;

    private String password;

    private String name;

    private String surname;

    private String carNumber;

    public UserRequestDTO(RegisterRequestDTO user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.carNumber = user.getCarNumber();
    }
}
