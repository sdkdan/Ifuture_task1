package sample;

import java.util.ArrayList;

public class User {
    private String name;
    private String surName;
    private String password;
    private String login;
    public static int userCount;
    public static ArrayList<User> users = new ArrayList<>();

    public User(){
        userCount++;
        users.add(this);
    }

    public User(String name, String surName, String password, String login){
        this.name = name;
        this.surName = surName;
        this.password = password;
        this.login = login;
        userCount++;
        users.add(this);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
