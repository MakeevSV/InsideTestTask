package com.makeev.inside.dao;

import com.makeev.inside.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface MessageRepo extends JpaRepository<Message, Integer> {

}
