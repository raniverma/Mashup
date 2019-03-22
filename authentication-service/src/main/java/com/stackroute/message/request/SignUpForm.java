package com.stackroute.message.request;

import java.util.Set;

import javax.validation.constraints.*;


// setter and getter function for some fields of the registration data
// to save in authentication data for verification
public class SignUpForm {
    @NotBlank
    private String name;

    @NotBlank
    private String username;

    @NotBlank
    @Size(max = 50)
    private String email;
    
    private Set<String> role;
    
    @NotBlank
    @Size(min = 6, max = 50)
    private String password;

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }
}