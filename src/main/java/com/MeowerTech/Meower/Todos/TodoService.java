package com.MeowerTech.Meower.Todos;

import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Service
public class TodoService {
    private static List<TodoModel> todos = new ArrayList<TodoModel>();
    private static long idCounter = 0;

    static {
        todos.add(new TodoModel(++idCounter, "Learn Angular", new Date(), false ));
        todos.add(new TodoModel(++idCounter, "Meow Meow", new Date(), false));
        todos.add(new TodoModel(++idCounter, "Meower Tech Is Proud", new Date(), false));
    }

    public List<TodoModel> findAll(String username) {
        return todos;
    }

    public TodoModel save(TodoModel todo) {
        if (todo.getId() == -1 || todo.getId() == 0) {
            todo.setId(++idCounter);
            todos.add(todo);
            return todo;
        } else {
            deleteById(todo.getId());
            todos.add(todo);
        }
        return todo;
    }

    //read carefully since i dont fully understand what this does
    public TodoModel deleteById(long id) {
        TodoModel todo = findById(id);

        if (todo == null) {
            return null;
        } else {
            todos.remove(todo);
            return todo;
        }
    }

    public TodoModel findById(long id) {
        for (TodoModel todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }
    //till here is to be read carefully again
}
