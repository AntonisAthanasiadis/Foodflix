package org.future.foodflix;

public class User {
    private String username;
    private String password;
    private String realName;
    private String surName;

    public User(String username, String password, String realName, String surName) {
        this.username = username;
        this.password = password;
        this.realName = realName;
        this.surName = surName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }
}
