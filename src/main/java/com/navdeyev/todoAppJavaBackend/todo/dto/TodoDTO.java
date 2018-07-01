package com.navdeyev.todoAppJavaBackend.todo.dto;

import java.util.ArrayList;
import java.util.List;

public class TodoDTO {

    private String id;
    private String title;
    private String goal;
    private TodoStatus status;
    private List<TodoStepDTO> steps = new ArrayList<>();

    public TodoDTO(String id,
                   String title,
                   String goal,
                   TodoStatus status,
                   List<TodoStepDTO> steps) {
        this.id = id;
        this.title = title;
        this.goal = goal;
        this.status = status;
        this.steps = steps;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGoal() {
        return goal;
    }

    public TodoStatus getStatus() {
        return status;
    }

    public List<TodoStepDTO> getSteps() {
        return steps;
    }
}
