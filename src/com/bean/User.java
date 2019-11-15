package com.bean;

/*
用户表
*/

public class User {
    private int id;
    private String username;
    private String password;

    public User(){
        super();
    }

    public User(int id, String name, String password){
        this.id = id;
        this.username = name;
        this.password = password;
    }
    public int getId(){
        return id;
    }

    public void setId(int id1){
        this.id = id1;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {

        this.username = userName;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

}
