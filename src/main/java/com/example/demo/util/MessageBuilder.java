package com.example.demo.util;

import com.example.demo.entity.Chat;
import com.example.demo.entity.Message;
import com.example.demo.entity.User;

import java.util.Date;

public class MessageBuilder {
    private int id;
    private String content;
    private Date timestamp;
    private User senderID;
    private Chat chatID;

    public MessageBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public MessageBuilder setContent(String content) {
        this.content = content;
        return this;
    }

    public MessageBuilder setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public MessageBuilder setSenderID(User senderID) {
        this.senderID = senderID;
        return this;
    }

    public MessageBuilder setChatID(Chat chatID) {
        this.chatID = chatID;
        return this;
    }

    public Message createMessage() {
        return new Message(id, content, timestamp, senderID, chatID);
    }
}