package kz.kbtu.oop.projectv2.news;

import kz.kbtu.oop.projectv2.users.User;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Comment implements Comparable<Comment>{

    private User user;
    private String content;
    private Date date;



    public Comment(User user, String content) {
        this.user = user;
        this.content = content;
        this.date = new Date();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd     HH:mm");
        return  user + "    " + sdf.format(date) + "/n" +
                "   " + content;
    }

    @Override
    public int compareTo(Comment o) {
        return -this.date.compareTo(o.getDate());
    }
}
