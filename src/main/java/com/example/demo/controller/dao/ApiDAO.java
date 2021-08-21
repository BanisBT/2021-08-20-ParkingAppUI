package com.example.demo.controller.dao;

import com.example.demo.model.ParkingFine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class ApiDAO {

    @Value("${url.api}")
    private String url;

    private final RestTemplate restTemplate;

    public ApiDAO(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ParkingFine getFineById(Long id) {
        return restTemplate.getForObject(url + "/fines/{id}", ParkingFine.class, id);
    }
}
