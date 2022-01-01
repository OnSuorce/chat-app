package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.service.UsersService;
import com.example.demo.util.UserBuilder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsersServiceTests {

    @Autowired
    UsersService service;

    @Test
    void Test() throws Exception{
        User user = new UserBuilder()
                .setUsername("maury")
                .setPassword("1ee")
                .setName("Mario")
                .setSurname("Locatelli")
                .createUser();
        user.setId(1);
        service.updateUser(user);
    }

    @Test
    void TestUserById(){
        User user = service.getUser(1);
        assertEquals("Mario", user.getName());
    }
}
