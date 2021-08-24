package com.example.demo.model.parking;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class ParkingTicketRequestTDO {

        @NotBlank
        private String parkingCity;

        @NotBlank
        private String parkingZone;
}
