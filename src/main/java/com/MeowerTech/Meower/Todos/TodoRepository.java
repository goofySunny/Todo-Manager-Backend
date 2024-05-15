package com.MeowerTech.Meower.Todos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import com.MeowerTech.Meower.user.User;

@Repository
public interface TodoRepository extends JpaRepository<TodoModel, String> {

    List<TodoModel> findAllByUser(User user);

    @org.springframework.lang.NonNull
    Optional<TodoModel> findById(@NonNull String id);
}
