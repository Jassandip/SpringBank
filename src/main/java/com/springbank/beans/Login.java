package com.springbank.beans;

public class Login{
    String id;
    String password;
    String type;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Login(String id, String password, String type) {
        this.id = id;
        this.password = password;
        this.type = type;
    }

}