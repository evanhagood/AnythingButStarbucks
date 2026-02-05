package com.anythingbutstarbucks.web.controller;

import com.anythingbutstarbucks.auth.dto.LoginRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String showForm() {
        return "login";
    }

//    @PostMapping
//    public String login(
//            @Valid LoginRequest request,
//            BindingResult bindingRequest
//    ) {
//
//    }
}
