package ru.itgirl.hakaton_march2024.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.itgirl.hakaton_march2024.model.dto.MatrixDto;
import ru.itgirl.hakaton_march2024.model.dto.TaskDto;
import ru.itgirl.hakaton_march2024.model.entity.Task;
import ru.itgirl.hakaton_march2024.model.entity.User;
import ru.itgirl.hakaton_march2024.model.repository.TaskRepository;
import ru.itgirl.hakaton_march2024.model.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    @Override
    public void createTasks(MatrixDto matrixDto) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user = userRepository.findByUsername(username).orElseThrow();
        List <Task> tasks = matrixDto.getTasks().stream().map(taskDto -> Task.builder()
                .user(user)
                .type(taskDto.getType())
                .text(taskDto.getText())
                .done(taskDto.getDone())
                .build()).toList();
        taskRepository.saveAll(tasks);
    }

    @Override
    public List<TaskDto> getTasks() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user = userRepository.findByUsername(username).orElseThrow();
        List <Task> tasks = taskRepository.findTaskByUserId(user.getId());
        return tasks.stream().map(task -> TaskDto.builder()
                .text(task.getText())
                .type(task.getType())
                .done(task.getDone())
                .build()).toList();
    }
}
