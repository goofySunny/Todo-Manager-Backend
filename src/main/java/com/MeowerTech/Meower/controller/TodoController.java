package com.MeowerTech.Meower.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.MeowerTech.Meower.model.TodoModel;
import com.MeowerTech.Meower.service.TodoService;

import javax.naming.NameNotFoundException;
import java.util.List;


@RestController
@RequestMapping
public class TodoController {


    @Autowired
    private TodoService todoService;




    @GetMapping("/users/{username}/todos")
    public List<TodoModel> getAllTodos(@PathVariable String username) throws NameNotFoundException {
        List<TodoModel> todos = todoService.findAllByUsername(username);
        return todos;
    }

    @GetMapping("/users/{username}/todos/{id}")
    public TodoModel getTodo(@PathVariable String username, @PathVariable String id) throws NameNotFoundException {
        return todoService.findById(id);
    }

    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<TodoModel> updateTodo(@PathVariable String username,
                                                @PathVariable String id,
                                                @RequestBody TodoModel todo) throws NameNotFoundException {
        this.todoService.save(todo, username);
        return new ResponseEntity<>(todo, HttpStatus.OK);

    }

    @PostMapping("/users/{username}/todos")
    public ResponseEntity<TodoModel> saveNewTodo(@PathVariable String username, @RequestBody TodoModel todo) throws NameNotFoundException {
        this.todoService.save(todo, username);

        return ResponseEntity.ok(todo);

    }


    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable String username, @PathVariable String id) throws NameNotFoundException {
        todoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }   
}