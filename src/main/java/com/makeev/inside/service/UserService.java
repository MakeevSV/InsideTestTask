package com.makeev.inside.service;

import com.makeev.inside.dao.UserRepo;
import com.makeev.inside.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;
    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    public Optional<Author> findByName(String name){
        return userRepo.findUserByNameIgnoreCase(name);
    }
}
