package es.grupo12.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;
    private String mail;
    private String password;

    public User() {
        // Used by JPA
    }

    private User(String username, String mail, String password) {

        this.username = username;
        this.mail = mail;
        this.password = password;
    }

    private String getUsername() {
        return this.username;
    }

    private String getMail() {
        return this.mail;
    }

    private String getPassword() {
        return this.password;
    }


}
