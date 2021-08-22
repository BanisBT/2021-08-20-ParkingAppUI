package com.example.demo.controller.dao;

import com.example.demo.model.parking.ParkingFine;
import com.example.demo.model.parking.ParkingFineRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Slf4j
@Component
public class ParkingFineApiDAO {

    @Value("${url.api}")
    private String url;

    private final RestTemplate restTemplate;

    public ParkingFineApiDAO(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ParkingFine getFineById(Long id) {
        return restTemplate.getForObject(url + "/fines/{id}", ParkingFine.class, id);
    }

    public ParkingFine createFine() {
        ParkingFineRequestDTO fineRequest = new ParkingFineRequestDTO(3L, "KAUNAS",
                "KAUNAS_BLUE_ZONE");
        return restTemplate.postForObject(url + "/fines/create", fineRequest,
                ParkingFine.class);
    }

    public void deleteFine(Long id) {
        restTemplate.delete(url + "/fines/{id}", id);
    }

    public List<ParkingFine> getFines() {
       return Arrays.asList(Objects.requireNonNull(restTemplate.getForObject(url + "/fines", ParkingFine[].class)));
    }
}
