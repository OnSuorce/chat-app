package com.example.demo.service;

import com.example.demo.dao.ChatsDao;
import com.example.demo.dao.UsersInChatDao;
import com.example.demo.entity.Chat;
import com.example.demo.entity.Group;
import com.example.demo.entity.User;
import com.example.demo.entity.UserInChat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class ChatsService {

    @Autowired
    ChatsDao chatsDao;

    @Autowired
    UsersInChatDao usersInChatDao;

    @Transactional(rollbackOn = Exception.class)
    public User[]  getUsersInChat(Chat chat){
        Set<UserInChat> userInChatSet = chat.getUserInChatList();
        User[] usersInChatArray = new User[userInChatSet.size()];

        int i = 0;
        for (UserInChat uic: userInChatSet) {
            usersInChatArray[i] = uic.getUserID();
            i++;
        }
        return  usersInChatArray;
    }

    @Transactional(rollbackOn = Exception.class)
    public boolean isUserInChat(Chat chat, User user){
        return usersInChatDao.findByChatIDAndUserID(chat,user) != null;
    }

    @Transactional(rollbackOn = Exception.class)
    public void addUserToChat(Chat chat, User user){
        UserInChat userInChat = new UserInChat();
        userInChat.setChatID(chat);
        userInChat.setUserID(user);
        usersInChatDao.save(userInChat);
    }

    @Transactional(rollbackOn = Exception.class)
    public Chat getChat(int id) throws NoSuchElementException {
        return chatsDao.findById(id).get();
    }

    @Transactional(rollbackOn = Exception.class)
    public Chat createChat(){
       return createChat(null);
    }

    @Transactional(rollbackOn = Exception.class)
    public Chat createChat(Group group){
        Chat chat = new Chat();
        chat.setGroupID(group);
        chat = chatsDao.save(chat);
        return chat;
    }
}
