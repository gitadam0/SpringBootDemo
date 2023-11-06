package com.example.demoSpringBoot2.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "userslist")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int PersonID;
    String username;
    String email;

    public User() {
    }

    public User(int personID, String username) {
        PersonID = personID;
        this.username = username;
    }
    public User(int personID, String username,String email) {
        PersonID = personID;
        this.username = username;
        this.email = email;
    }
    public User( String username,String email) {

        this.username = username;
        this.email = email;
    }

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int personID) {
        PersonID = personID;
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

    @Override
    public String toString() {
        return "User{" +
                "PersonID=" + PersonID +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
