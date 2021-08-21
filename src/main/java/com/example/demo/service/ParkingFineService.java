package com.example.demo.service;

import com.example.demo.controller.dao.ApiDAO;
import com.example.demo.model.ParkingFine;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class ParkingFineService {

    private final ApiDAO apiDAO;

    public ParkingFineService(ApiDAO apiDAO) {
        this.apiDAO = apiDAO;
    }

    public ParkingFine getFineById(Long id) {
        LocalDateTime now = LocalDateTime.now();
        return apiDAO.getFineById(id);
//        return new ParkingFine(1L, "Banis", "Vilnius", "Vilnius Blue",
//                "Paid", now, BigDecimal.TEN, now, now);
    }
}
