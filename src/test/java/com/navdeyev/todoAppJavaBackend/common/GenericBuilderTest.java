package com.navdeyev.todoAppJavaBackend.common;

import com.navdeyev.todoAppJavaBackend.todo.domains.TodoStep;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GenericBuilderTest {
    @Test
    public void testGenericBuilder() {
        TodoStep todoStep = GenericBuilder.of(TodoStep::new)
                .with(TodoStep::setId, "someId")
                .with(TodoStep::setTitle, "title")
                .with(TodoStep::setDetails, "details")
                .build();

        assertEquals(todoStep.getId(), "someId");
        assertEquals(todoStep.getTitle(), "title");
        assertEquals(todoStep.getDetails(), "details");
    }
}