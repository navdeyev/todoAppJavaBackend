package com.navdeyev.todoAppJavaBackend.todo;

import com.navdeyev.todoAppJavaBackend.todo.domains.Todo;
import com.navdeyev.todoAppJavaBackend.todo.domains.TodoRepository;
import com.navdeyev.todoAppJavaBackend.todo.domains.TodoStatus;
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

    TodoStatus getNextStatus(TodoStatus todoStatus) {
        if (TodoStatus.PENDING.equals(todoStatus)) {
            return TodoStatus.IN_PROGRESS;
        }
        if (TodoStatus.IN_PROGRESS.equals(todoStatus)) {
            return TodoStatus.COMPLETE;
        }
        if (TodoStatus.COMPLETE.equals(todoStatus)) {
            return TodoStatus.PENDING;
        }
        return TodoStatus.PENDING;
    }

    Collection<Todo> updateTodoStatus(String id) {
        Todo todo = todoRepository.getById(id);
        todo.setStatus(getNextStatus(todo.getStatus()));
        todoRepository.save(todo);
        return getTodos();
    }

}
