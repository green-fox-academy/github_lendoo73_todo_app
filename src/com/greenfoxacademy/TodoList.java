package com.greenfoxacademy;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private List<Todo> todos;

    public TodoList() {
        this.todos = new ArrayList<>();
    }

    public TodoList(List<Todo> todos) {
        this.todos = todos;
    }

    public void add(Todo todo) {
        this.todos.add(todo);
    }
}
