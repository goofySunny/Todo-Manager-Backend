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
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final UserService userService;


    @Override
    public List<TodoModel> findAllByUsername(String username) throws NameNotFoundException {
        User user = userService.getUser(username);
        return todoRepository.findAllByUser(user);
    }

    @Override
    public TodoModel save(TodoModel todo, String username) throws NameNotFoundException {
        User user = userService.getUser(username);
        if (todo.getId() == "-1") {
            todo.setId(null);
            todo.setUser(user);
            todoRepository.save(todo);
        } else {
            TodoModel savedModel = findById(todo.getId());
            savedModel.setDate(todo.getDate() != null ? todo.getDate() : savedModel.getDate());
            savedModel.setDesc((todo.getDesc() != null ? todo.getDesc() : savedModel.getDesc()));
            savedModel.setDone(todo.getDone() != null ? todo.getDone() : savedModel.getDone());
            todoRepository.save(savedModel);
        }
        return todo;
    }

    @Override
    public TodoModel findById(String id) throws NameNotFoundException {
        Optional<TodoModel> todo = todoRepository.findById(id);
        if (todo.isPresent()) {
        return todoRepository.findById(id).get();
        } else {
            // TODO: custom exceptions
            throw new NameNotFoundException("Not Found");
        }
    }

    @Override
    public void deleteById(String id) throws NameNotFoundException {
        Optional<TodoModel> todo = todoRepository.findById(id);
        if (todo.isPresent()) {
            todoRepository.deleteById(id);
        } else {
            // TODO: custom exceptions
            throw new NameNotFoundException("Not Found");
        }
    }


}
