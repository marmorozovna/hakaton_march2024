package ru.itgirl.hakaton_march2024.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itgirl.hakaton_march2024.model.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository <Task, Long> {
    List<Task> findTaskByUserId (Long id);
}
