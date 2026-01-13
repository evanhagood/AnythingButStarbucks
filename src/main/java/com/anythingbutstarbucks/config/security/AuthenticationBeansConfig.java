package com.anythingbutstarbucks.config.security;

import com.anythingbutstarbucks.user.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AuthenticationBeansConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService userDetailsService(UserRepository repo) {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String rawEmail) {
                String email = rawEmail.trim().toLowerCase();
                return repo.findByEmail(email)
                        .orElseThrow(() -> new UsernameNotFoundException("Invalid credentials"));
            }
        };
    }


}
