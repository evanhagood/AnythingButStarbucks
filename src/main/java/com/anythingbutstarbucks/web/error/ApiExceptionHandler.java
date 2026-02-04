package com.anythingbutstarbucks.web.error;

import com.anythingbutstarbucks.auth.exception.DisplayNameAlreadyInUseException;
import com.anythingbutstarbucks.auth.exception.EmailAlreadyInUseException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(EmailAlreadyInUseException.class)
    public String handleEmailTaken(
            EmailAlreadyInUseException ex,
            RedirectAttributes redirectAttributes
    ) {
        redirectAttributes.addFlashAttribute("error", ex.getMessage());
        return "redirect:/register";
    }

    @ExceptionHandler(DisplayNameAlreadyInUseException.class)
    public String handleDisplayNameTaken(
            DisplayNameAlreadyInUseException ex,
            RedirectAttributes redirectAttributes
    ) {
        redirectAttributes.addFlashAttribute("error", ex.getMessage());
        return "redirect:/register";
    }
}
