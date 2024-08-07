package com.example.IT_support._App.repositoreis;

import com.example.IT_support._App.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByEmail(String email);
    Optional<User> findByUsername(String username);
}
