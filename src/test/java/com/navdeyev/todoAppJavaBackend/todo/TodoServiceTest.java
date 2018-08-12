package com.navdeyev.todoAppJavaBackend.todo;

import com.navdeyev.todoAppJavaBackend.common.GenericBuilder;
import com.navdeyev.todoAppJavaBackend.todo.domains.Todo;
import com.navdeyev.todoAppJavaBackend.todo.domains.TodoRepository;
import com.navdeyev.todoAppJavaBackend.todo.domains.TodoStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @Spy
    @InjectMocks
    private TodoService todoService;

    @Test
    public void getNextStatus() {
        assertEquals(todoService.getNextStatus(null), TodoStatus.PENDING);
        assertEquals(todoService.getNextStatus(TodoStatus.PENDING), TodoStatus.IN_PROGRESS);
        assertEquals(todoService.getNextStatus(TodoStatus.IN_PROGRESS), TodoStatus.COMPLETE);
        assertEquals(todoService.getNextStatus(TodoStatus.COMPLETE), TodoStatus.PENDING);
    }

    @Test
    public void testUpdateStatus() {
        Todo todo = GenericBuilder.of(Todo::new)
                .with(Todo::setId, "someId")
                .with(Todo::setStatus, TodoStatus.PENDING)
                .build();

        when(todoRepository.getById(todo.getId())).thenReturn(todo);

        todoService.updateTodoStatus(todo.getId());

        assertEquals(TodoStatus.IN_PROGRESS, todo.getStatus());
        verify(todoRepository, times(1)).save(todo);
        verify(todoService, times(1)).getTodos();
    }
}