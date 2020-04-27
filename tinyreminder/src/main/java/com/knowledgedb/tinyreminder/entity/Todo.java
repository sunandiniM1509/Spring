package com.knowledgedb.tinyreminder.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "todo")
public class Todo {
    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String Name;

   // @Size(min = 10, message = "Enter at least 10 Characters...")
    @Column(name = "description")
    private String Description;

    @Column(name = "duration")
    private String Duration;

    public Todo() {
    }

    public Todo(String name, String description, String duration) {
        super();
        this.Name = name;
        this.Description = description;
        this.Duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        this.Duration = duration;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", name='" + Name +
                ", description='" + Description +
                ", duration='" + Duration +
                '}';
    }
}