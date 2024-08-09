package com.example.IT_support._App.repositoreis;

import com.example.IT_support._App.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String userName);
    boolean existsByEmail(String email);

}
