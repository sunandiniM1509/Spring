package com.knowledgedb.tinyreminder;

import com.knowledgedb.tinyreminder.dao.TodoRepository;
import com.knowledgedb.tinyreminder.entity.Todo;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.knowledgedb.tinyreminder.service.TodoServiceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoServiceImpl todoService;

    @Test
    public void testFindAll() {

        Todo todo=new Todo("himanshu","reading books","10 min");
        List<Todo> expectedTodos = Arrays.asList(todo);

        doReturn(expectedTodos).when(todoRepository).findAll();

        List<Todo> actualTodos = todoService.findAll();


        assertThat(actualTodos).isEqualTo(expectedTodos);
    }

    @Test
    public void testFindById() {
        Todo todo=new Todo("mike ross","practice law","30 min");
        Mockito.when(todoRepository.findById(todo.getId())).thenReturn(Optional.of(todo));
        Todo actualTodo=todoService.findById(todo.getId());
        assertThat(actualTodo).isEqualTo(todo);
    }

    @Test
    public void testDelete() {
        Todo todo=new Todo("harvey","ballet dancing","12 min");
        todoService.deleteById(todo.getId());
        verify(todoRepository,times(1)).deleteById(todo.getId());
    }

    @Test
    public void testSave() {
        Todo todo=new Todo("meghan","cooking pasta","10 min");
        todoService.save(todo);
        verify(todoRepository,times(1)).save(todo);
    }
}