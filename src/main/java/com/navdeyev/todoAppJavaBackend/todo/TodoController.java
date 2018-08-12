package com.navdeyev.todoAppJavaBackend.todo;

import com.navdeyev.todoAppJavaBackend.todo.domains.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class TodoController {
    private  static final String origins = "http://localhost:3000";

    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @CrossOrigin(origins = origins)
    @GetMapping("/api/todoList")
    public Collection<Todo> todos() {
        return todoService.getTodos();
    }

    @CrossOrigin(origins = origins)
    @GetMapping("/api/todoList/{id}")
    public Todo todo(@PathVariable("id") String id) {
        return todoService.getTodo(id);
    }

    @CrossOrigin(origins = origins)
    @PostMapping("/api/todoList/{id}/updateStatus")
    public Collection<Todo> updateTodoStatus(@PathVariable("id") String id) {
        return todoService.updateTodoStatus(id);
    }

}
