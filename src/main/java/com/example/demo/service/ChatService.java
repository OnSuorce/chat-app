package com.example.demo.service;

import com.example.demo.dao.UsersDao;
import com.example.demo.entity.User;
import com.example.demo.util.UserBuilder;
import com.mysql.cj.exceptions.DataTruncationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLIntegrityConstraintViolationException;

@Service
public class ChatService {
    private Logger log = LogManager.getLogger(ChatService.class);

    @Autowired
    UsersDao usersDao;

    public User getUser(int id){
        return usersDao.getById(id);
    }

    public User getUser(String username){
        return usersDao.findByUsername(username);
    }

    public User getUser(String name, String surname){
        return usersDao.findByNameAndSurname(name,surname);
    }

    public boolean usernameAvailable(String username){
        if(getUser(username) == null)return false;
        return true;
    }


    @Transactional(rollbackOn = Exception.class)
    public void saveUser(String username, String password, String name, String surname) throws SQLIntegrityConstraintViolationException, DataTruncationException{
        if(usernameAvailable(username)){
            User user = new UserBuilder()
                    .setUsername(username)
                    .setName(name)
                    .setPassword(password)
                    .setSurname(surname)
                    .createUser();
            log.debug("Trying to register new user: {}", user);

            usersDao.save(user);
        }


    }

    @Transactional(rollbackOn = Exception.class)
    public void deleteUser(User user){
        usersDao.delete(user);
    }

    @Transactional(rollbackOn = Exception.class)
    public void deleteUserById(int id){
        usersDao.deleteById(id);
    }

    @Transactional(rollbackOn = Exception.class)
    public void updateUser(User user){
        User dbuser = usersDao.getById(user.getId());
        dbuser.setName(user.getName());
        dbuser.setUsername(user.getUsername());
        dbuser.setSurname(user.getSurname());
        dbuser.setPassword(user.getPassword());
        usersDao.save(dbuser);
    }


}
