package com.example.demo;

import com.example.demo.dao.MessagesDao;
import com.example.demo.dao.UsersDao;
import com.example.demo.util.UserBuilder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {


	@Test
	void contextLoads() {
		boolean prova = true;
		assertTrue(prova);
	}
}
