package com.booleanuk.api;
// this is the background Class and these are the objects you will get back.
public class Author {
    private String name;
    private String email;

    public Author (String name, String email){
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
