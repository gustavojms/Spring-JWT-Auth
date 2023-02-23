package com.example.springjwt.auth.service;

import com.example.springjwt.auth.controller.AuthenticationRequest;
import com.example.springjwt.auth.controller.AuthenticationResponse;
import com.example.springjwt.auth.controller.RegisterRequest;
import com.example.springjwt.services.JwtService;
import com.example.springjwt.user.model.Role;
import com.example.springjwt.user.model.UserModel;
import com.example.springjwt.user.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {

        var user = UserModel.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        var userRegistered = userRepository.save(user);

        var jwtToken = jwtService.generateToken(user, Map.of("id", userRegistered.getId()));
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())

        );

        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user, Map.of("id", user.getId()));

        return AuthenticationResponse.builder()
                .token(jwtService.generateToken(user, Map.of("id", user.getId())))
                .build();
    }
}
