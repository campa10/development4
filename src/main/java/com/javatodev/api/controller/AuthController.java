package com.javatodev.api.controller;

import com.javatodev.api.configuration.JWTUtil;
import com.javatodev.api.model.AuthRequest;
import com.javatodev.api.model.AuthResponse;
import com.javatodev.api.service.ApiUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final ApiUserDetailsService apiUserDetailsService;
    private final JWTUtil jwtUtil;

    @PostMapping
    public ResponseEntity<AuthResponse> createAuthToken(@RequestBody AuthRequest authRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (Exception e) {
            throw new BadCredentialsException("Incorrect username or password");
        }
        final UserDetails userDetails = apiUserDetailsService.loadUserByUsername(authRequest.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails);

        return new ResponseEntity<>(new AuthResponse(jwt), new HttpHeaders(), HttpStatus.OK);
    }
}
