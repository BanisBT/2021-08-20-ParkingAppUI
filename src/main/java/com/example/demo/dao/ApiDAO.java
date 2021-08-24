package com.example.demo.dao;

import com.example.demo.model.parking.ParkingFine;
import com.example.demo.model.parking.ParkingFineRequestDTO;
import com.example.demo.model.parking.ParkingTicket;
import com.example.demo.model.parking.ParkingTicketRequestTDO;
import com.example.demo.model.user.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

    public User register(RegisterRequestDTO registerRequestDTO){
        return restTemplate.postForObject(url + "/register", new UserRequestDTO(registerRequestDTO), User.class);
    }

    public LoginResponseDTO login(String username, String password) {
        return restTemplate.postForObject(url + "/login", new LoginRequestDTO(username, password), LoginResponseDTO.class);
    }

    public ParkingTicket createTicket(ParkingTicketRequestTDO ticketDTO) {
        return null;
    }

    public ParkingTicket getTicket(Long id) {
       return restTemplate.getForObject(url + "/{id}", ParkingTicket.class, id);
    }
}
