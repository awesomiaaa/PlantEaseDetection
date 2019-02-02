package com.example.deguzman.pne;

public class UserList {
    private String username;
    private String email;
    private String password;

    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }


    public UserList(String username, String email, String password) {
       this.username = username;
       this.email = email;
       this.password = password;


    }
}
