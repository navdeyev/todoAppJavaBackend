package com.navdeyev.todoAppJavaBackend.todo.domains;

import javax.persistence.*;
import java.util.List;

@Entity
public class Todo {

    @Id
    private String id;
    private String title;
    private String goal;
    @Enumerated(EnumType.STRING)
    private TodoStatus status;

    @OneToMany(mappedBy="todo")
    private List<TodoStep> steps;

    public Todo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public TodoStatus getStatus() {
        return status;
    }

    public void setStatus(TodoStatus status) {
        this.status = status;
    }

    public List<TodoStep> getSteps() {
        return steps;
    }

    public void setSteps(List<TodoStep> steps) {
        this.steps = steps;
    }
}
