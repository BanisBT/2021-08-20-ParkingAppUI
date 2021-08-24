package com.example.demo.model.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginResponseDTO {

    private String loginToken;

    private User userDTO;
}
