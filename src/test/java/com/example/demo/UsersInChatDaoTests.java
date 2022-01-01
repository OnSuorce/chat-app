package com.example.demo;

import com.example.demo.dao.UsersInChatDao;
import com.example.demo.entity.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
public class UsersInChatDaoTests {
    @Autowired
    UsersInChatDao usersInChatDao;

    @Test
    @Transactional
    void test(){

        User user = usersInChatDao.findById(1).get().getUserID();
        assertEquals(1,user.getId());
    }
}
