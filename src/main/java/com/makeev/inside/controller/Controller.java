package com.makeev.inside.controller;

import com.makeev.inside.dto.MessageDto;
import com.makeev.inside.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class Controller {
    private final MessageService messageService;
    @Autowired
    public Controller(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/message")
    public ResponseEntity messageDispatcher(@RequestBody MessageDto message){
        if(messageService.keyChecker(message).isPresent()){
           return new ResponseEntity(messageService.getLastNMessage(message), HttpStatus.OK);
        }
        messageService.newMessage(message);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
