package com.navdeyev.todoAppJavaBackend.todo.dto;

public class TodoStepDTO {

    private String id;
    private String title;
    private String details;

    public TodoStepDTO(String id, String title, String details) {
        this.id = id;
        this.title = title;
        this.details = details;
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
