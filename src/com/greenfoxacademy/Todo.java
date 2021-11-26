package com.greenfoxacademy;

public class Todo {
    private String description;
    private boolean isDone;

    public Todo(String description) {
        this.description = description;
        this.isDone = false;
    }

    public Todo(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }
}
