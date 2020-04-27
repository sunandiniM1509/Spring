package com.knowledgedb.tinyreminder.controller;

import java.util.List;

import com.knowledgedb.tinyreminder.entity.Todo;
import com.knowledgedb.tinyreminder.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/todos")
public class TodoController {

    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/list")
    public String listTodos(Model theModel) {

        List<Todo> theTodos = todoService.findAll();

        theModel.addAttribute("todos",theTodos);

        return "todo-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        Todo theTodo= new Todo();

        theModel.addAttribute("todo",theTodo);

        return "todo-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("todoId") int theId , Model theModel) {

        Todo theTodo = todoService.findById(theId);

        theModel.addAttribute("todo",theTodo);

        return "todo-form";
    }

    @PostMapping("/save")
    public String saveTodo(@Valid @ModelAttribute("todo") Todo theTodo, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "todo-form";

        todoService.save(theTodo);

        return "redirect:/todos/list";

    }

    @GetMapping("/delete")
    public String delete(@RequestParam("todoId") int theId) {

        todoService.deleteById(theId);

        return "redirect:/todos/list";

    }


}
