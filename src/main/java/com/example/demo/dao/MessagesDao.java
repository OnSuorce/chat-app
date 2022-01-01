package com.example.demo.dao;

import com.example.demo.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessagesDao extends JpaRepository<Message, Integer> {
}
