package com.example.demo.model.parking;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ParkingTicket {

    private Long id;

    private String username;

    private String parkingCity;

    private String parkingZone;

    private String recordStatus;

    private LocalDateTime parkingBegan;

    private LocalDateTime parkingEnd;

    private BigDecimal ticketAmount;

    private LocalDateTime ticketDateTime;
}
