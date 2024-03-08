package com.MeowerTech.Meower.Todos;

import org.springframework.stereotype.Service;
import com.MeowerTech.Meower.user.User;
import com.MeowerTech.Meower.user.UserService;

import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;
import javax.naming.NameNotFoundException;


@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final UserService userService;


    public List<TodoModel> findAllByUsername(String username) throws ClassNotFoundException {
        User user = userService.getUser(username);
        return todoRepository.findAllByUser(user);
    }

    public TodoModel save(TodoModel todo, String username) throws ClassNotFoundException {
        User user = userService.getUser(username);
        if (todo.getId() == -1 || todo.getId() == 0) {
            todo.setId(null);
            todo.setUser(user);
            todoRepository.save(todo);
        } else {
            deleteById(todo.getId());
            todo.setUser(user);
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

    public TodoModel deleteById(long id) {
        Optional<TodoModel> todo = todoRepository.findById(id);
        
        if (todo.isPresent()) {
            todoRepository.deleteById(id);
            return todo.get();
        } else {
            return null;
        }
    }


}
