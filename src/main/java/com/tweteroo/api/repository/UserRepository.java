package com.tweteroo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.model.UserModel;

import java.util.List;

public interface UserRepository  extends JpaRepository<UserModel, Long> {

    List<UserModel> findByUsername (String username);
    
}
