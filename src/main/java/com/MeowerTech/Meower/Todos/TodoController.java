package com.MeowerTech.Meower.Todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.naming.NameNotFoundException;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping
public class TodoController {


    @Autowired
    private TodoService todoService;




    @GetMapping("/users/{username}/todos")
    public List<TodoModel> getAllTodos(@PathVariable String username) throws ClassNotFoundException {
        List<TodoModel> todos = todoService.findAllByUsername(username);
        return todos;
    }

    @GetMapping("/users/{username}/todos/{id}")
    public TodoModel getTodo(@PathVariable String username, @PathVariable long id) throws NameNotFoundException {
        return todoService.findById(id);
    }

    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<TodoModel> updateTodo(@PathVariable String username,
                                                @PathVariable long id,
                                                @RequestBody TodoModel todo) throws ClassNotFoundException {
        this.todoService.save(todo, username);
        return new ResponseEntity<>(todo, HttpStatus.OK);

    }

    @PostMapping("/users/{username}/todos")
    public ResponseEntity<TodoModel> saveNewTodo(@PathVariable String username,
                                                @RequestBody TodoModel todo) throws ClassNotFoundException {
        this.todoService.save(todo, username);


        return ResponseEntity.ok(todo);

    }


    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String username, @PathVariable long id) {
        if (this.todoService.deleteById(id) != null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
