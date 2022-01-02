package com.example.demo.service;

import com.example.demo.dao.MessagesDao;
import com.example.demo.entity.Chat;
import com.example.demo.entity.Message;
import com.example.demo.entity.User;
import com.example.demo.util.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.NoSuchElementException;

@Service
public class MessagesService {
    @Autowired
    MessagesDao messagesDao;

    @Transactional(rollbackOn = Exception.class)
    public void sendMessage(User sender, Chat chat, String content){
        Message message = new MessageBuilder()
                .setSenderID(sender)
                .setChatID(chat)
                .setContent(content)
                .setTimestamp(new Date())
                .createMessage();
        messagesDao.save(message);
    }

    @Transactional(rollbackOn = Exception.class)
    public Message getMessage(int id) throws NoSuchElementException {
        return messagesDao.findById(id).get();
    }
}
