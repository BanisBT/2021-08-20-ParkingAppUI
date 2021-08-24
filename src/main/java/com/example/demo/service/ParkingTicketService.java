package com.example.demo.service;

import com.example.demo.dao.ApiDAO;
import com.example.demo.model.parking.ParkingTicket;
import com.example.demo.model.parking.ParkingTicketRequestTDO;
import org.springframework.stereotype.Service;

@Service
public class ParkingTicketService {

    private final ApiDAO apiDAO;

    public ParkingTicketService(ApiDAO apiDAO) {
        this.apiDAO = apiDAO;
    }

    public ParkingTicket createTicket(ParkingTicketRequestTDO ticketDTO) {
        return null;
    }

    public ParkingTicket getTicket(Long id) {
        return apiDAO.getTicket(id);
    }
}
