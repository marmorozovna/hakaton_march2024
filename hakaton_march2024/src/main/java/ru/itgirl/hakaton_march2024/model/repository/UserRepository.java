package ru.itgirl.hakaton_march2024.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itgirl.hakaton_march2024.model.entity.User;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

