package com.navdeyev.todoAppJavaBackend.todo.domains;

import javax.persistence.*;

@Entity
public class TodoStep {

    @Id
    private String id;
    private String title;
    private String details;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todoFk")
    private Todo todo;

    public TodoStep() {
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}
