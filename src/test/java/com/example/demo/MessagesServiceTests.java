package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.service.ChatsService;
import com.example.demo.service.MessagesService;
import com.example.demo.service.UsersService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MessagesServiceTests {
    @Autowired
    MessagesService messagesService;
    @Autowired
    UsersService usersService;
    @Autowired
    ChatsService chatsService;

    @Test
    void sendMessageTest(){
        User u1 = usersService.getUser(1);
        User u2 = usersService.getUser(3);
       messagesService.sendMessage(u1, chatsService.getChat(1),"ciao");
    }
}
