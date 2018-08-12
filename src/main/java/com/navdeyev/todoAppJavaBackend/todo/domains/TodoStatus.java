package com.navdeyev.todoAppJavaBackend.todo.domains;

public enum TodoStatus {
    PENDING("PENDING"),
    IN_PROGRESS("IN_PROGRESS"),
    COMPLETE("COMPLETE");

    private final String identifier;

    TodoStatus(String id) {
        this.identifier = id;
    }

    public String getIdentifier() {
        return identifier;
    }
}
