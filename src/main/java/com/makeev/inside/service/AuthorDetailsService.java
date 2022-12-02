package com.makeev.inside.service;

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
    private final UserService userService;
    @Autowired
    public AuthorDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Author> author = userService.findByName(username);

        if(author.isEmpty()){
            throw new UsernameNotFoundException("Author not found");
        }

        return new AuthorDetails(author.get());
    }
}
