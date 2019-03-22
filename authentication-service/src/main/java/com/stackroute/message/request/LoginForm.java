package com.stackroute.message.request;

import javax.validation.constraints.NotBlank;

// setter and getter functions for the username and password to login
public class LoginForm {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

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
}