package com.example.demo.dto;

import com.example.demo.enumeration.SystemMessageType;

public class SystemMessage {

    SystemMessageType type;
    String content;

    public SystemMessage(SystemMessageType type, String username) {
        this.type = type;
        this.content = username;
    }

    public SystemMessageType getType() {
        return type;
    }

    public void setType(SystemMessageType type) {
        this.type = type;
    }

    public String getUsername() {
        return content;
    }

    public void setUsername(String username) {
        this.content = username;
    }

    @Override
    public String toString() {
        return "SystemMessage{" +
                "type=" + type +
                ", username='" + content + '\'' +
                '}';
    }
}
