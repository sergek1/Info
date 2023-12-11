package com.Info.model.entity;// User.java
import jakarta.persistence.*;


@Entity

@Table(name = "my_user")
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    public String getUsername() {
        return username;
    }
    public MyUser() {}

    public MyUser( String username) {
        this.username = username;
    }
}