package com.example.demo.service;

import com.example.demo.dao.ChatsDao;
import com.example.demo.entity.Chat;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;

@Service
public class ChatsService {

    @Autowired
    ChatsDao chatsDao;

    @Transactional(rollbackOn = Exception.class)
    public Chat getChat(int id) throws NoSuchElementException {
        return chatsDao.findById(id).get();
    }

    @Transactional(rollbackOn = Exception.class)
    public int createChat(User user1, User user2){

        return 0;
    }

    @Transactional(rollbackOn = Exception.class)
    public int createChatGroup(User owner, String name, Chat chat){
        return 0;
    }
}
