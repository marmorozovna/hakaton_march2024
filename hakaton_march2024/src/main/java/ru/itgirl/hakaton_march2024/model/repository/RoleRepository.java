package ru.itgirl.hakaton_march2024.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itgirl.hakaton_march2024.model.entity.Role;
import ru.itgirl.hakaton_march2024.model.entity.User;

import java.util.Optional;

public interface RoleRepository extends JpaRepository <Role,Long> {
    Optional<Role> findByName(String username);
}
