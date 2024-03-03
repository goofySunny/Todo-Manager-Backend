package com.MeowerTech.Meower.Todos;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TodoRepository extends JpaRepository<TodoModel, Long> {

    List<TodoModel> findAllByUsername(String username);

    TodoModel save(TodoModel todo);

    void deleteById(Long todoId);

    Optional<TodoModel> findById(Long id);
    
}
