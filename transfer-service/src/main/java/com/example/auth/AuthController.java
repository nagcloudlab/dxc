package com.example.auth;

import com.example.auth.dto.AuthRequest;
import com.example.auth.dto.AuthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AuthController {

    private AuthenticationManager authenticationManager;
    private JwtUtils jwtUtils;

    public AuthController(AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping(
            value = "/auth",
            produces = {"application/json"},
            consumes = {"application/json"})
    public @ResponseBody
    AuthResponse authenticate(@RequestBody AuthRequest authRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new RuntimeException("incorrect username or password");
        }
        // Token
        UserDetails userDetails = new User(authRequest.getUsername(), authRequest.getPassword(), List.of());
        String jwtToken = jwtUtils.generateToken(userDetails);
        AuthResponse authResponse = new AuthResponse(jwtToken);
        return authResponse;
    }

}
