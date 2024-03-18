package com.MeowerTech.Meower.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    //All Good

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    Optional<User> findByName(String name);
}
