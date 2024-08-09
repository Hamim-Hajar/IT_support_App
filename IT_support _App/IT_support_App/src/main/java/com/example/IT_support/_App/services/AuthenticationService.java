package com.example.IT_support._App.services;


import com.example.IT_support._App.dto.LoginUserDto;
import com.example.IT_support._App.dto.RegisterUserDto;
import com.example.IT_support._App.entities.Admin;
import com.example.IT_support._App.entities.Technicien;
import com.example.IT_support._App.entities.User;
import com.example.IT_support._App.entities.UserStandar;

import com.example.IT_support._App.enums.UserRole;
import com.example.IT_support._App.repositoreis.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(RegisterUserDto input) {
        User user;

        switch (input.getRole()) {
            case UserRole.USER:
                user = new UserStandar();
                break;
            case UserRole.TECHNICIEN:
                user = new Technicien();
                break;
            case UserRole.ADMIN:
                user = new Admin();
                break;
            default:
                throw new IllegalArgumentException("Invalid user role");
        }

        user.setUsername(input.getUserName());
        user.setEmail(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setRole(input.getRole());

        return userRepository.save(user);
    }
    public User authenticate(LoginUserDto input) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            input.getUserName(),
                            input.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            User user = userRepository.findByUsername(input.getUserName());
            if (user == null) {
                throw new UsernameNotFoundException("User not found with username: " + input.getUserName());
            }
            return user;
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Invalid username or password");
        } catch (Exception e) {
            throw new RuntimeException("Authentication failed: " + e.getMessage(), e);
        }
    }
}
