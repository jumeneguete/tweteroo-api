package com.tweteroo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.UserDTO;
import com.tweteroo.api.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/sign-up")
public class SignUpController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody @Valid UserDTO body) {
        boolean existingUser = service.getUserByUsername(body.username());

        if (existingUser) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already existis!");
        }

        service.createUser(body);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ok");
    }

}
