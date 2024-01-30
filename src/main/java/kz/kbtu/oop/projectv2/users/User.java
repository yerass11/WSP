package kz.kbtu.oop.projectv2.users;

import kz.kbtu.oop.projectv2.logs.ILogged;
import kz.kbtu.oop.projectv2.news.NewsList;
import kz.kbtu.oop.projectv2.social.Message;

import java.util.*;
import java.util.Vector;

public abstract class User implements ILogged {
    private static final Set<User> users = new HashSet<>();
    protected static final Map<String, HashMap<Language, String>> phrases;
    protected Vector<Message> messages;
    private String id;

    private String fullname;
    private String email;
    private String password;
    protected Language language;

    public User() {
        messages = new Vector<>();
    }


    static {
        phrases = new HashMap<>();
    }

    public User(String id, String fullname) {
        this.id = id;
        this.fullname = fullname;
        this.language = Language.EN;
    }

    public User(String id, String fullname, String email, String password) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
    }

    public boolean authenticate(String email, String password){
        return this.email.equals(email) && this.password.equals(password);
    }

    public static User addUser(User u){
        users.add(u);
        return u;
    }

    public static void removeUser(User u){
        users.remove(u);
    }

    public static User findUser(String userId) {
        for (User u : users) {
            if (u.getId().equals(userId)) {
                return u;
            }
        }
        return null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(fullname, user.fullname) && Objects.equals(email, user.email) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullname, email, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", fullname='" + fullname + '\'' +
                '}';
    }

    public void readNews(NewsList news){
        System.out.println(news);
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return fullname;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.fullname = fullname;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public static <T extends User> Vector<T> getAllUsers(Class<T> classType) {
        // TO-DO
        return new Vector<>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    protected void setPhrase(String phrase, Language lang, String content) {
        phrases.putIfAbsent(phrase, new HashMap<>());
        phrases.get(phrase).put(lang, content);
    }

    protected String getPhrase(String phrase) {
        return phrases.get(phrase).get(language);
    }

    public void sendMessage(String itTo, String content) {
        Message.sendMessage(this.getId(), itTo, content);
    }
    public void receiveMessage(Message message) {
        messages.add(message);
    }

    public void printMessages() {
        System.out.println(messages);
    }

    public String logMessage() {
        return this.toString();
    }

}
