package com.example.demo.service;

import com.example.demo.controller.dao.ParkingFineApiDAO;
import com.example.demo.model.parking.ParkingFine;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingFineService {

    private final ParkingFineApiDAO parkingFineApiDAO;

    public ParkingFineService(ParkingFineApiDAO parkingFineApiDAO) {
        this.parkingFineApiDAO = parkingFineApiDAO;
    }

    public ParkingFine getFineById(Long id) {
        return parkingFineApiDAO.getFineById(id);
    }

    public List<ParkingFine> getFines() {
        return parkingFineApiDAO.getFines();
    }

    public void test(){
        parkingFineApiDAO.deleteFine(2L);
//        parkingFineApiDAO.createFine();
    }
}
