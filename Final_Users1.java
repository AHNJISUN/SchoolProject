package com.example.finalproj_2022_1;

public class Users1 {
    String name;
    String mail;
    String id;

    public Users1(String id, String name, String mail) {
        this.id = id;
        this.name = name;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
