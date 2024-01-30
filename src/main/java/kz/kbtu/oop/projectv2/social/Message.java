package kz.kbtu.oop.projectv2.social;

import kz.kbtu.oop.projectv2.users.User;

import java.util.Date;

public class Message {
    private User sender;
    private User receiver;
    private String content;
    private Date timestamp;

    public Message(User sender, User receiver, String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public static void sendMessage(String idFrom, String idTo, String content) {
        User from = User.findUser(idFrom);
        User to = User.findUser(idTo);
        Message message = new Message(from, to, content);
        assert to != null;
        to.receiveMessage(message);
    }
}