package com.knowledgedb.tinyreminder.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.knowledgedb.tinyreminder.entity.Todo;


public interface TodoRepository extends JpaRepository<Todo, Integer> {

    /* no need to write any code..
    *Jpa provides nearly sufficient methods to implement
    */

    //But still if I need a customised method...

    //can create a class and implement this method and provide custom behaviour
    //public Todo findTodoByName(String name);
}