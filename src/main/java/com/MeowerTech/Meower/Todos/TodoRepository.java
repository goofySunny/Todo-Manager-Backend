package com.MeowerTech.Meower.Todos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.MeowerTech.Meower.user.User;

@Repository
public interface TodoRepository extends JpaRepository<TodoModel, String> {

    List<TodoModel> findAllByUser(User user);
}
