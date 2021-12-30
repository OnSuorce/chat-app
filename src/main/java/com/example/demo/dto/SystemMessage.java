package com.example.demo.dto;

import com.example.demo.enumeration.SystemMessageType;

public class SystemMessage {

    SystemMessageType type;
    String username;

    public SystemMessage(SystemMessageType type, String username) {
        this.type = type;
        this.username = username;
    }

    public SystemMessageType getType() {
        return type;
    }

    public void setType(SystemMessageType type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "SystemMessage{" +
                "type=" + type +
                ", username='" + username + '\'' +
                '}';
    }
}
