package com.example.demo.controller;

import com.example.demo.service.ParkingFineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fines")
public class ParkingFineController {

    private final ParkingFineService fineService;

    public ParkingFineController(ParkingFineService fineService) {
        this.fineService = fineService;
    }

    @GetMapping("/{id}")
    public String getParkingFine(@PathVariable(required = false) Long id, Model model) {
        model.addAttribute("fine", fineService.getFineById(id));
        return "/fines/view";
    }

    @GetMapping
    public String getFines(Model model) {
        model.addAttribute("fines", fineService.getFines());
        return "/fines/index";
    }

    @GetMapping("/test")
    public String test(){
        fineService.test();
        return "redirect:/fines/view";
    }
}
