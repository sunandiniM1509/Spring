package com.knowledgedb.tinyreminder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knowledgedb.tinyreminder.dao.TodoRepository;
import com.knowledgedb.tinyreminder.entity.Todo;

@Service
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository theTodoRepository)
    {
        this.todoRepository=theTodoRepository;
    }

    @Override
    public List<Todo> findAll()
    {
        return todoRepository.findAll();
    }

    //@Override
    //public Todo getTodoByName(String name) {
        //return todoRepository.findTodoByName(name);
    //}

    @Override
    public Todo findById(int id)
    {
            Optional<Todo> result = todoRepository.findById(id);

            Todo theTodo=null;
            if(result.isPresent())
                theTodo=result.get();
            else
               throw new RuntimeException("Todo's with id: "+ id +" does not exists.");
            return theTodo;
    }

    @Override
    public void updateTodo(Todo todo) {
        todoRepository.save(todo);
    }

    @Override
    public void addTodo(String name, String description, String duration) {
        todoRepository.save(new Todo(name, description, duration));
    }

    @Override
    public void deleteById(int id) {
        todoRepository.deleteById(id);
    }

    @Override
    public void save(Todo todo) {
        todoRepository.save(todo);
    }
}