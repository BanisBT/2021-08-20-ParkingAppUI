package com.example.demo.controller;

import com.example.demo.model.parking.ParkingTicket;
import com.example.demo.model.parking.ParkingTicketRequestTDO;
import com.example.demo.service.ParkingTicketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/tickets")
public class ParkingTicketController {

    private final ParkingTicketService ticketService;

    public ParkingTicketController(ParkingTicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/create")
    public String createTicket(@Valid ParkingTicketRequestTDO ticketRequest, Model model) {
        model.addAttribute("ticketDTO", new ParkingTicketRequestTDO());

        return "tickets/create";
    }

    @GetMapping("/{id}")
    public String getTicket(@PathVariable(required = false) Long id, Model model) {
        model.addAttribute("ticket", ticketService.getTicket(id));
        return "/tickets/view";
    }
}
