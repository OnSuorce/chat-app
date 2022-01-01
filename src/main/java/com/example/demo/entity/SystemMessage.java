package com.example.demo.entity;

import com.example.demo.enumeration.SystemMessageType;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "system_messages")
public class SystemMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private SystemMessageType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chatID", nullable = false)
    private Chat chatID;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "timestamp", nullable = false)
    private Date timestamp;

    public SystemMessage() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public SystemMessageType getType() {
        return type;
    }

    public void setType(SystemMessageType type) {
        this.type = type;
    }


    public Chat getChatID() {
        return chatID;
    }

    public void setChatID(Chat chatID) {
        this.chatID = chatID;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SystemMessage that = (SystemMessage) o;
        return chatID == that.chatID && Objects.equals(content, that.content) && type == that.type && Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, type, chatID, timestamp);
    }

    @Override
    public String toString() {
        return "SystemMessage{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", type=" + type +
                ", chatID=" + chatID +
                ", timestamp=" + timestamp +
                '}';
    }
}
