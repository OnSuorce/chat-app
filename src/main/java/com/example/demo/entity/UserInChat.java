package com.example.demo.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users_in_chat")
public class UserInChat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID", nullable = false)
    private User userID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chatID", nullable = false)
    private Chat chatID;
    public UserInChat() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public Chat getChatID() {
        return chatID;
    }

    public void setChatID(Chat chatID) {
        this.chatID = chatID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInChat that = (UserInChat) o;
        return userID == that.userID && chatID == that.chatID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, chatID);
    }

    @Override
    public String toString() {
        return "UserInChat{" +
                "id=" + id +
                ", userID=" + userID +
                ", chatID=" + chatID +
                '}';
    }
}
