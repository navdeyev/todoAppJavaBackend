package com.navdeyev.todoAppJavaBackend.todo.domains;

import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, String> {

    Todo getById(String id);

}

