package com.example.demo.dto;

public class Connection {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Connection{" +
                "username='" + username + '\'' +
                '}';
    }
}
