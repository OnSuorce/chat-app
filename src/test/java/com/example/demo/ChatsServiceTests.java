package com.example.demo;

import com.example.demo.entity.Chat;
import com.example.demo.entity.User;
import com.example.demo.entity.UserInChat;
import com.example.demo.service.ChatsService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Set;

@SpringBootTest
public class ChatsServiceTests {
    @Autowired
    ChatsService chatsService;

    @Test
    void makeChatTest(){
        Chat chat = chatsService.createChat();
        assertNotNull(chat);
    }

    @Test
    void getChatTest(){
        Chat chat = chatsService.getChat(5);
        assertNotNull(chat);
    }

    @Test
    void getUserInChatTest(){
        Chat chat = chatsService.getChat(1);
        User[] userInChatSet = chatsService.getUsersInChat(chat);
        assertEquals(userInChatSet.length,2);

    }

    @Test
    void isUserInChatTest(){
        Chat chat = chatsService.getChat(1);
        User[] userInChat = chatsService.getUsersInChat(chat);
        assertTrue(chatsService.isUserInChat(chat, userInChat[0]));
    }
}
