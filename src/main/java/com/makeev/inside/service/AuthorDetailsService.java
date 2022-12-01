package com.makeev.inside.service;

import com.makeev.inside.dao.UserRepo;
import com.makeev.inside.model.Author;
import com.makeev.inside.security.AuthorDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorDetailsService implements UserDetailsService {

    private final UserRepo userRepo;
    @Autowired
    public AuthorDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Author> author = userRepo.findUserByNameIgnoreCase(username);

        if(author.isEmpty()){
            throw new UsernameNotFoundException("Author not found");
        }

        return new AuthorDetails(author.get());
    }
}
