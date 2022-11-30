package com.makeev.inside.dao;

import com.makeev.inside.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Author, Integer> {

    @Query("select u from Author u where u.name = ?1")
    Optional<Author> findUserByName(String name);

}
