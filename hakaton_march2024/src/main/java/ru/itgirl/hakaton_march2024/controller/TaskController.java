package ru.itgirl.hakaton_march2024.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.itgirl.hakaton_march2024.model.dto.MatrixDto;
import ru.itgirl.hakaton_march2024.model.dto.TaskDto;
import ru.itgirl.hakaton_march2024.model.service.TaskService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/tasks")
    List<TaskDto> getTasks() {
        return taskService.getTasks();
    }

    @PostMapping("/task/create")
    void createTask(@RequestBody MatrixDto matrixDto) {
       taskService.createTasks(matrixDto);
    }
}
