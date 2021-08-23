package com.example.demo.service;

import com.example.demo.dao.ApiDAO;
import com.example.demo.model.parking.ParkingFine;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingFineService {

    private final ApiDAO apiDAO;

    public ParkingFineService(ApiDAO apiDAO) {
        this.apiDAO = apiDAO;
    }

    public ParkingFine getFineById(Long id) {
        return apiDAO.getFineById(id);
    }

    public List<ParkingFine> getFines() {
        return apiDAO.getFines();
    }

    public void test(){
        apiDAO.deleteFine(2L);
//        parkingFineApiDAO.createFine();
    }
}
