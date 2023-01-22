package com.tweteroo.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.service.TweetsService;
import com.tweteroo.api.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tweets")
public class TweetsController {
    
    @Autowired
    private TweetsService service;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> createTweet(@RequestBody @Valid TweetDTO req){
        boolean existingUser = userService.getUserByUsername(req.username());

        if (existingUser) {
            service.createTweet(req);
            return ResponseEntity.status(HttpStatus.CREATED).body("Ok");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found. Please, sign up to tweet!");
        }

        
    }

}
