package com.example.demo.controller;

import com.example.demo.model.user.User;
import com.example.demo.model.user.LoginRequestDTO;
import com.example.demo.model.user.RegisterRequestDTO;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping()
public class MainController {

    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String login(Model model, @AuthenticationPrincipal User user) {
        if (user == null) {
            model.addAttribute("user", new LoginRequestDTO());
            return "login";
        }
        return "redirect:/";
    }

    @GetMapping("register")
    public String register(Model model) {
        model.addAttribute("user", new RegisterRequestDTO());
        return "register";
    }

    @PostMapping("register")
    public String createUser(@Valid RegisterRequestDTO registerRequestDTO, BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("user", registerRequestDTO);
            log.info("Invalid user {}", registerRequestDTO);
            return "register";
        }
        if (registerRequestDTO.getPassword().equals(registerRequestDTO.getPasswordConfirm())) {
            errors.addError(new ObjectError("user", "Password do not match"));
        }

        userService.register(registerRequestDTO);
        log.info("User {} has been register", registerRequestDTO);
        return "redirect:/";
    }
}
