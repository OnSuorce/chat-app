package com.example.demo.util;

import com.example.demo.entity.User;

public class UserBuilder {
    private String username;
    private String password;
    private String name;
    private String surname;

    public UserBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public User createUser() {
        return new User(username, password, name, surname);
    }
}