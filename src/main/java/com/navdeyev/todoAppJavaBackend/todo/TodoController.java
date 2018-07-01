package com.navdeyev.todoAppJavaBackend.todo;

import com.navdeyev.todoAppJavaBackend.todo.dto.TodoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class TodoController {

    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/todoList")
    public Collection<TodoDTO> users() {
        return todoService.getTodos();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/api/todoList/{id}")
    public TodoDTO user(@PathVariable("id") String id) {
        Collection<TodoDTO> todos = todoService.getTodos();
        return todos.stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst()
                .get();
    }

}
