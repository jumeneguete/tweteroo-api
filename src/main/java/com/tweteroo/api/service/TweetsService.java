package com.tweteroo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model.TweetModel;
import com.tweteroo.api.model.UserModel;
import com.tweteroo.api.repository.TweetsRepository;
import com.tweteroo.api.repository.UserRepository;

@Service
public class TweetsService {

    @Autowired
    private TweetsRepository repository;

    @Autowired
    private UserRepository userRepository;

    public void createTweet(TweetDTO req) {

        List<UserModel> user = userRepository.findByUsername(req.username());
        repository.save(new TweetModel(req, user.get(0).getAvatar()));
    }

    public Page<TweetModel> getTweetsByUsername(String username, int page, int size) {

        PageRequest pageRequest = PageRequest.of(page, size);
        return repository.findByUsername(username, pageRequest);
    }

    public Page<TweetModel> getAllTweets(int page, int size) {

        PageRequest pageRequest = PageRequest.of(page, size);
        return repository.findAll(pageRequest);
    }

}
