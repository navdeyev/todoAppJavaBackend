package com.navdeyev.todoAppJavaBackend.todo;

import com.navdeyev.todoAppJavaBackend.common.GenericBuilder;
import com.navdeyev.todoAppJavaBackend.todo.domains.Todo;
import com.navdeyev.todoAppJavaBackend.todo.domains.TodoStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.Collections;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TodoController.class)
public class TodoControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TodoController todoController;

    private Todo createTodo() {
        return GenericBuilder.of(Todo::new)
                .with(Todo::setId, "someId")
                .with(Todo::setStatus, TodoStatus.PENDING)
                .build();
    }

    @Test
    public void testTodos() throws Exception {
        Todo todo = createTodo();
        when(todoController.todos()).thenReturn(Collections.singletonList(todo));

        String requestUri = "/api/todoList";
        RequestBuilder builder = get(requestUri).contentType(APPLICATION_JSON);
        mvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("[0].id", is(todo.getId())))
                .andExpect(jsonPath("[0].status", is(todo.getStatus().name())));
    }

    @Test
    public void testTodo() throws Exception {
        Todo todo = createTodo();
        when(todoController.todo(todo.getId())).thenReturn(todo);

        String requestUri = "/api/todoList/" + todo.getId();
        RequestBuilder builder = get(requestUri).contentType(APPLICATION_JSON);
        mvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", is(todo.getId())))
                .andExpect(jsonPath("status", is(todo.getStatus().name())));
    }

    @Test
    public void testUpdateTodoStatus() throws Exception {
        Todo todo = createTodo();
        when(todoController.updateTodoStatus(todo.getId())).thenReturn(Collections.singletonList(todo));

        String requestUri = "/api/todoList/" + todo.getId() + "/updateStatus";
        RequestBuilder builder = post(requestUri).contentType(APPLICATION_JSON);
        mvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("[0].id", is(todo.getId())))
                .andExpect(jsonPath("[0].status", is(todo.getStatus().name())));
    }

}