package com.example.demo.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "chats")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupID", nullable = true)
    private Group groupID;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "chatID")
    private Set<UserInChat> UserInChatList = new HashSet<>();

    public Chat(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Group getGroupID() {
        return groupID;
    }

    public void setGroupID(Group groupID) {
        this.groupID = groupID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chat chat = (Chat) o;
        return id == chat.id && Objects.equals(groupID, chat.groupID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, groupID);
    }

    public Set<UserInChat> getUserInChatList() {
        return UserInChatList;
    }

    public void setUserInChatList(Set<UserInChat> userInChatList) {
        UserInChatList = userInChatList;
    }
}
