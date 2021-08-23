package com.example.demo.service;

import com.example.demo.dao.ApiDAO;
import com.example.demo.exception.UsernameAlreadyExistException;
import com.example.demo.model.user.LoginResponseDTO;
import com.example.demo.model.user.User;
import com.example.demo.model.user.RegisterRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class UserService {

    private final ApiDAO apiDAO;

    public UserService(ApiDAO apiDAO) {
        this.apiDAO = apiDAO;
    }

    public User register(RegisterRequestDTO registerRequestDTO) {
        try {
            return apiDAO.register(registerRequestDTO);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().equals(HttpStatus.CONFLICT)) {
                throw new UsernameAlreadyExistException(registerRequestDTO.getUsername());
            }
            throw e;
        }
    }

    public LoginResponseDTO login(String username, String password) {
        return apiDAO.login(username, password);
    }
}
