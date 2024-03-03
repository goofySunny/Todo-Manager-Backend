package com.MeowerTech.Meower.Todos;

import org.springframework.stereotype.Service;

import com.MeowerTech.Meower.config.JwtService;

import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;
import javax.naming.NameNotFoundException;


@Service
@RequiredArgsConstructor
public class TodoService {

    private final JwtService jwtService;
    private final TodoRepository todoRepository;

    public String extractJWT(String token) {
        return token.substring(7);
    }

    public List<TodoModel> findAllByUsername(String token) {
        String jwt =extractJWT(token);
        String username = jwtService.extractUsername(token);
        return todoRepository.findAllByUsername(username);
    }

    public TodoModel save(TodoModel todo) {
        if (todo.getId() == -1 || todo.getId() == 0) {
            todo.setId(null);
            todoRepository.save(todo);
        } else {
            deleteById(todo.getId());
            todoRepository.save(todo);
        }
        return todo;
    }

    public TodoModel findById(long id) throws NameNotFoundException {
        Optional<TodoModel> todo = todoRepository.findById(id);
        if (todo.isPresent()) {
        return todoRepository.findById(id).get();
        } else {
            throw new NameNotFoundException("Such a Todo Doesnt Exist");
        }
    }

    public TodoModel deleteById(Long id) {
        Optional<TodoModel> todo = todoRepository.findById(id);
        
        if (todo.isPresent()) {
            todoRepository.deleteById(id);
            return todo.get();
        } else {
            return null;
        }
    }


}
