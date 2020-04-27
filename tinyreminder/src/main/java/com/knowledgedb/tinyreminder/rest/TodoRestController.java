package com.knowledgedb.tinyreminder.rest;

import java.util.List;

import com.knowledgedb.tinyreminder.entity.Todo;
import com.knowledgedb.tinyreminder.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/reminder")
public class TodoRestController {

    private TodoService todoService;

    @Autowired
    public TodoRestController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("todos")
    public List<Todo> findAll()
    {
        return todoService.findAll();
    }

    @GetMapping("/todos/{todoId}")
    public Todo getTodo(@PathVariable int todoId) {

        Todo theTodo = todoService.findById(todoId);

        if (theTodo == null) {
            throw new RuntimeException("Todo's with id: "+ todoId +" does not exists.");
        }
        return theTodo;
    }

  /*  @GetMapping("/list-todos/{TodoName}")
    public Todo findTodoByName(@PathVariable String TodoName) {
        Todo theTodo = todoService.getTodoByName(TodoName);

        if(theTodo == null)
            throw new RuntimeException("Todo's with name: "+ TodoName +" does not exists.");
        return theTodo;
    }*/

    //add new todos
    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo theTodo) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theTodo.setId(0);

        todoService.save(theTodo);

        return theTodo;
    }

    // add mapping for PUT /list-todos - update existing Todos

    @PutMapping("/todos")
    public Todo updateTodo(@RequestBody Todo theTodo) {

        todoService.save(theTodo);

        return theTodo;
    }

// add mapping for DELETE /employees/{employeeId} - delete employee

    @DeleteMapping("/todos/{todoId}")
    public String deleteTodo(@PathVariable int todoId) {

        Todo tempTodo = todoService.findById(todoId);

        // throw exception if null

        if (tempTodo == null) {
            throw new RuntimeException("Todo id not found - " + todoId);
        }

        todoService.deleteById(todoId);

        return "Deleted Todo with id - " + todoId;
        // return "redirect:/list-todos";
    }
}