package com.example.kamja2;

public class User {
    private String username;
    private String password;
    private String nickname;

    public User(){

    }

    public User(String username, String password, String nickname){
        this.username = username;
        this.password = password;
        this.nickname = nickname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }


}