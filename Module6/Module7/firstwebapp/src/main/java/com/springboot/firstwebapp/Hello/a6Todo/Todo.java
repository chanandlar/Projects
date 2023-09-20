package com.springboot.firstwebapp.Hello.a6Todo;

import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class Todo {
    private int id;
    private String username;
    @Size(min=10,message = "Enter atleast 10 characters")
    private String description;
    private LocalDate target_date;
    private boolean done;

    public Todo(int id, String username, String description, LocalDate target_date, boolean done) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.target_date = target_date;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTarget_date() {
        return target_date;
    }

    public void setTarget_date(LocalDate target_date) {
        this.target_date = target_date;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", target_date=" + target_date +
                ", done=" + done +
                '}';
    }
}
