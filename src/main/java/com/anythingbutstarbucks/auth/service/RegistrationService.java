package com.anythingbutstarbucks.auth.service;

import com.anythingbutstarbucks.auth.dto.RegisterRequest;
import com.anythingbutstarbucks.auth.exception.DisplayNameAlreadyInUseException;
import com.anythingbutstarbucks.auth.exception.EmailAlreadyInUseException;
import com.anythingbutstarbucks.user.User;
import com.anythingbutstarbucks.user.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RegistrationService {
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public RegistrationService(
            UserRepository userRepo,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public UUID register(RegisterRequest request) {
        if(userRepo.existsByEmail(request.email())) {
            throw new EmailAlreadyInUseException(request.email());
        }
        if(userRepo.existsByDisplayName(request.displayName())) {
            throw new DisplayNameAlreadyInUseException(request.displayName());
        }
        User user = User.builder()
                .email(request.email().trim().toLowerCase())
                .displayName(request.displayName())
                .passwordHash(passwordEncoder.encode(request.password()))
                .build();

        userRepo.save(user);
        return user.getId();
    }
}
