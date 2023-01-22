package com.tweteroo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model.TweetModel;
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
    public ResponseEntity<String> createTweet(@RequestBody @Valid TweetDTO req) {
        boolean existingUser = existingUser(req.username());

        if (existingUser) {
            service.createTweet(req);
            return ResponseEntity.status(HttpStatus.CREATED).body("Ok");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found. Please, sign up to tweet!");
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<Page<TweetModel>> getTweetsByUsername(@PathVariable String username,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "2") int size) {
        boolean existingUser = existingUser(username);

        if (!existingUser) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        Page<TweetModel> list = service.getTweetsByUsername(username, page, size);
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping
    public Page<TweetModel> getAllTweets(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "2") int size) {

        return service.getAllTweets(page, size);
    }

    private boolean existingUser(String username) {
        return userService.getUserByUsername(username);
    }
}
