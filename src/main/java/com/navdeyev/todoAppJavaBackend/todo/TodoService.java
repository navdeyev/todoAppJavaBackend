package com.navdeyev.todoAppJavaBackend.todo;

import com.navdeyev.todoAppJavaBackend.todo.dto.TodoDTO;
import com.navdeyev.todoAppJavaBackend.todo.dto.TodoStatus;
import com.navdeyev.todoAppJavaBackend.todo.dto.TodoStepDTO;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class TodoService {

    List<TodoDTO> getTodos() {

        TodoDTO initRepoTodo = new TodoDTO(
                "todo-1",
                "Initialise the repo",
                "Get a working repo with all scripts set up for development",
                TodoStatus.PENDING,
                Arrays.asList(
                        new TodoStepDTO(
                                "todo-1-step-1",
                                "Install create-react-app",
                                "Run 'yarn global add create-react-app' from your console"
                        ),
                        new TodoStepDTO(
                                "todo-1-step-2",
                                "Initialise the repo",
                                "Go to directory and run 'create-react-app todoapp --scripts-version=react-scripts-ts' to initialise the repo in todoapp folder"
                        )
                ));

        TodoDTO backendTodo = new TodoDTO(
                "todo-2",
                "Simple koa backend",
                "Introduce a simple mock backend that will emulate the work of a real backend",
                TodoStatus.PENDING,
                Arrays.asList(
                        new TodoStepDTO(
                                "todo-2-step-1",
                                "Add necessary libraries",
                                "Add koa, koa-router and nodemon to the project"
                        ),
                        new TodoStepDTO(
                                "todo-2-step-2",
                                "Create 'server' directory",
                                "Server directory will contain all server-side code. Server.js contains the server launch script."
                        )
                ));

        return Arrays.asList(initRepoTodo, backendTodo);
    }

}
