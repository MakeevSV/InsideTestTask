package com.makeev.inside.service;

import com.makeev.inside.dto.MessageDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class MessageServiceTest {
    @Autowired
    MessageService messageService;


    @Test
    void newMessage() {
    }

    @Test
    void getLastNMessage() {
    }

    @Test
    void keyChecker() {
        Optional<Integer> result = messageService.keyChecker(new MessageDto("name","history 10"));
        Optional<Integer> result1 = messageService.keyChecker(new MessageDto("name","history 10gfd"));
        Optional<Integer> result2 = messageService.keyChecker(new MessageDto("name","history"));
        Optional<Integer> result3 = messageService.keyChecker(new MessageDto("name","Test"));
        Assertions.assertEquals(10,result.get());
        Assertions.assertEquals(true,result1.isEmpty());
        Assertions.assertEquals(true,result2.isEmpty());
        Assertions.assertEquals(true,result3.isEmpty());
    }
}