package com.example.IT_support._App.services;


import com.example.IT_support._App.dto.LoginUserDto;
import com.example.IT_support._App.dto.RegisterUserDto;
import com.example.IT_support._App.entities.Admin;
import com.example.IT_support._App.entities.Technicien;
import com.example.IT_support._App.entities.User;
import com.example.IT_support._App.entities.UserStandar;
import com.example.IT_support._App.enums.Role;
import com.example.IT_support._App.repositoreis.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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

//    public User signup(RegisterUserDto input) {
//        User user = new Admin();
//        user.setUsername(input.getUserName());
//        user.setEmail(input.getEmail());
//        user.setPassword(passwordEncoder.encode(input.getPassword()));
//        user.setRole(Role.USER);
//        return userRepository.save(user);
//    }
public User signup(RegisterUserDto input) {
    if (input == null || input.getUser_type() == null) {
        throw new IllegalArgumentException("User type cannot be null");
    }

    User user;
    String userType = input.getUser_type().toLowerCase();

    switch (userType) {
        case "admin":
            user = new Admin();
            user.setRole("ADMIN");
            break;
        case "tech":
            user = new Technicien();
            user.setRole("TECHNICIEN");
            break;
        default:
            user = new UserStandar();
            user.setRole("USER");
    }

    user.setUsername(input.getUserName());
    user.setEmail(input.getEmail());
    user.setPassword(passwordEncoder.encode(input.getPassword()));

    return userRepository.save(user);
}



    public User authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getUserName(),
                        input.getPassword()
                )
        );

        return userRepository.findByUsername(input.getUserName())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
