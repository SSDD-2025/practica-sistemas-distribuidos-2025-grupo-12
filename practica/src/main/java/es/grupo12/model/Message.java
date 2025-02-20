package es.grupo12.model;

import java.text.DateFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String text;
    private DateFormat date;
    private User from;
    private User to;

    public Message(String text, DateFormat date){
        this.text = text;
        this.date = date;
    }
    public String getText() {
    return text;
    }

    public User getFromUser() {
        return this.from;
    }

    public User getToUser() {
        return this.to;
    }

    public DateFormat getDate() {
    return date;
    }
   }
   