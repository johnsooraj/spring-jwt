package com.sample.controller;

import com.sample.models.UserDetails;
import com.sample.user.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/secure")
public class SecureController {

    @Autowired
    UserDetailsService userDetailsService;

    @Secured("ROLE_GUEST")
    @GetMapping("/user")
    public ResponseEntity<List<UserDetails>> findUserByName(
            @PathParam("name") String name,
            @PathParam("conditional") boolean conditional
    ) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return new ResponseEntity<>(userDetailsService.findUserByName(name, conditional), HttpStatus.OK);
    }
}
