package com.sample.controller;

import com.sample.authentication.AuthUserDetailsService;
import com.sample.authentication.JwtUtil;
import com.sample.models.AuthenticationRequest;
import com.sample.models.AuthenticationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/test")
public class CustomController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    AuthUserDetailsService authUserDetailsService;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/index1")
    public String index1() {
        return "index1";
    }

    @PostMapping(value = "/authenticated")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest request) throws Exception {
        log.info("REST API authentication starts");
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
        } catch (Exception e) {
            throw new Exception("invalid username or password!");
        }
        log.info("REST API authentication success and moving to JWT Token Generation");
        UserDetails details = authUserDetailsService.loadUserByUsername(request.getUsername());
        String token = jwtUtil.generateToken(details);
        log.info("REST API authentication success and token generated");
        return ResponseEntity.ok(new AuthenticationResponse(token));
    }
}
