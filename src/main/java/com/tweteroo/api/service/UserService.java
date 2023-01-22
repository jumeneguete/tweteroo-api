package com.tweteroo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.UserDTO;
import com.tweteroo.api.model.UserModel;
import com.tweteroo.api.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void createUser(UserDTO dto) {
        repository.save(new UserModel(dto));
    }

    public boolean getUserByUsername(String username) {
        List<UserModel> existingUser = repository.findByUsername(username);

        if (!existingUser.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
