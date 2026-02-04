package com.anythingbutstarbucks.web.controller;

import com.anythingbutstarbucks.auth.dto.RegisterRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @GetMapping()
    public String showForm(@ModelAttribute RegisterRequest req) {
        return "register";
    }

    @PostMapping()
    public String register(
            @Valid RegisterRequest registerRequest,
            BindingResult bindingResult
    ) {
        if(bindingResult.hasErrors()) {
            return "register";
        }

        // TODO: call the registration service to register user here.

        return "redirect:/login";
    }

}
