package com.tweteroo.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model.TweetModel;
import com.tweteroo.api.repository.TweetsRepository;

@Service
public class TweetsService {

    @Autowired
    private TweetsRepository repository;

    public void createTweet(TweetDTO req) {
        repository.save(new TweetModel(req));
    }
    
}
