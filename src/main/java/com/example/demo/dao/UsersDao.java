package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDao extends JpaRepository<User, Integer> {

    User findByName(String name);
    User findBySurname(String surname);
    User findByUsername(String username);
    User findByNameAndSurname(String name, String surname);


}
