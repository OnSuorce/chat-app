package com.example.demo.dao;

import com.example.demo.entity.Chat;
import com.example.demo.entity.User;
import com.example.demo.entity.UserInChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersInChatDao extends JpaRepository<UserInChat, Integer> {

        UserInChat findByChatIDAndUserID(Chat chat, User user);

}
