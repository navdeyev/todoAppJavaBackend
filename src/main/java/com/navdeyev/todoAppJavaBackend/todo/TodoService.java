package com.navdeyev.todoAppJavaBackend.todo;

import com.navdeyev.todoAppJavaBackend.todo.domains.Todo;
import com.navdeyev.todoAppJavaBackend.todo.domains.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    Todo getTodo(String id) {
        return todoRepository.getById(id);
    }

    Collection<Todo> getTodos() {
        Iterable<Todo> todos = todoRepository.findAll();

        List<Todo> todoList = new ArrayList<>();
        todos.forEach(todoList::add);

        return todoList;
    }

}
