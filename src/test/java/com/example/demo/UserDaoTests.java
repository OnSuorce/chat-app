package com.example.demo;

import com.example.demo.dao.UsersDao;
import com.example.demo.entity.User;
import com.example.demo.util.UserBuilder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
public class UserDaoTests {
    @Autowired
    UsersDao usersDao;

    @Test
    void findByNameTest(){
        User user = usersDao.findByName("giorgio");
        assertEquals("Locatelli", user.getSurname());
    }

    @Test
    void findByNameAndSurname(){
        User user = usersDao.findByNameAndSurname("Matteo","Bianchi");
        assertEquals("OnSuorce",user.getUsername());
    }

    @Test
    void findByUsername(){
        User user = usersDao.findByUsername("mikimaggio");
        assertEquals("22", user.getPassword());
    }

    @Test
    void saveUser(){
        User user = new UserBuilder()
                .setUsername("giorgy")
                .setPassword("1ee")
                .setName("Mario")
                .setSurname("Locatelli")
                .createUser();

        usersDao.save(user);
    }

    @Test
    //@Transactional(rollbackOn = Exception.class)
    void updateUser(){

            User user = usersDao.findByUsername("giorgy");
            user.setName("Mauro");
            usersDao.save(user);
            assertEquals("Mauro",user.getName());



    }
}
