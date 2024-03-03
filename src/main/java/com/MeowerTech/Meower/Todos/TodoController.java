package com.MeowerTech.Meower.Todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.lang.model.util.Elements;
import java.net.URI;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoController {


    @Autowired
    private TodoService todoService;




    @GetMapping("/users/{username}/todos")
    public List<TodoModel> getAllTodos(@PathVariable String username) {
        return todoService.findAll(username);
    }

    @GetMapping("/users/{username}/todos/{id}")
    public TodoModel getTodo(@PathVariable String username, @PathVariable long id) {
        return todoService.findById(id);
    }

    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<TodoModel> updateTodo(@PathVariable String username,
                                                @PathVariable long id,
                                                @RequestBody TodoModel todo) {
        this.todoService.save(todo);
        return new ResponseEntity<TodoModel>(todo, HttpStatus.OK);

    }

    @PostMapping("/users/{username}/todos")
    public ResponseEntity<TodoModel> saveNewTodo(@PathVariable String username,
                                                @RequestBody TodoModel todo) {
        TodoModel createdTodo = this.todoService.save(todo);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();

        return ResponseEntity.created(uri).build();

    }


    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String username, @PathVariable long id) {
        if (this.todoService.deleteById(id) != null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
