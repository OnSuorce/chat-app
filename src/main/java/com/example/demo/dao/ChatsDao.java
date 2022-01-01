package com.example.demo.dao;

import com.example.demo.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatsDao extends JpaRepository<Chat, Integer> {
}
