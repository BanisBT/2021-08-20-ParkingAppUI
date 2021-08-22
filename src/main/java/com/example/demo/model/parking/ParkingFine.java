package com.example.demo.model.parking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingFine {

        private Long id;

        private String username;

        private String parkingCity;

        private String parkingZone;

        private String recordStatus;

        private LocalDateTime fineDateTime;

        private BigDecimal fineAmount;
}
