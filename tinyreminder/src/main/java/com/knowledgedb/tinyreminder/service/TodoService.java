package com.knowledgedb.tinyreminder.service;

import com.knowledgedb.tinyreminder.entity.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {


    public List<Todo> findAll();//done (displayAll)

    public Todo findById(int id);//done (getTodoById)

    //public Todo getTodoByName(String name);//done

    public void updateTodo(Todo todo);//done

    public void addTodo(String name, String description, String duration);//done

    public void deleteById(int id); //done (deleteTodo)

    public void save(Todo todo);//not required

}
