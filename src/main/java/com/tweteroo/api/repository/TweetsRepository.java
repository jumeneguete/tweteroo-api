package com.tweteroo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.model.TweetModel;

public interface TweetsRepository extends JpaRepository<TweetModel, Long>{
    
}
