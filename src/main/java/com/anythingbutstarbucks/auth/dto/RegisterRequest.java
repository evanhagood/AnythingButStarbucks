package com.anythingbutstarbucks.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
        @NotBlank @Email String email,
        @NotBlank @Size(min = 8) String password,
        @NotBlank @Size(min=2, max = 20) String displayName
) {
    @Override
    public String toString() {
        return "RegisterRequest[email=%s, displayName=%s"
                .formatted(email, displayName);
    }
}
