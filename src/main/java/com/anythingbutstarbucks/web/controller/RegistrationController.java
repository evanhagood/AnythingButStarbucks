package com.anythingbutstarbucks.web.controller;

import com.anythingbutstarbucks.auth.dto.RegisterRequest;
import com.anythingbutstarbucks.auth.exception.DisplayNameAlreadyInUseException;
import com.anythingbutstarbucks.auth.exception.EmailAlreadyInUseException;
import com.anythingbutstarbucks.auth.service.RegistrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegistrationController {

    final RegistrationService regService;

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

        try {
            regService.register(registerRequest);
        } catch(EmailAlreadyInUseException emailException) {
            bindingResult.rejectValue(
                    "email",
                    "email.taken",
                    "Email is already in use."
            );
        } catch(DisplayNameAlreadyInUseException displayNameTaken) {
            bindingResult.rejectValue(
                    "displayName",
                    "displayName.taken",
                    "Display name is already in use."
            );
        }

        return "redirect:/login";
    }

}
