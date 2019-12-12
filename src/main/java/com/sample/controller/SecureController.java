package com.sample.controller;

import com.sample.models.UserDetails;
import com.sample.user.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/secure")
public class SecureController {

    @Autowired
    UserDetailsService userDetailsService;

    @GetMapping("/user")
    public ResponseEntity<List<UserDetails>> findUserByName(
            @PathParam("name") String name,
            @PathParam("conditional") boolean conditional
    ) {
        return new ResponseEntity<>(userDetailsService.findUserByName(name, conditional), HttpStatus.OK);
    }
}
