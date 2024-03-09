package ru.itgirl.hakaton_march2024.model.service;

import ru.itgirl.hakaton_march2024.model.dto.MatrixDto;
import ru.itgirl.hakaton_march2024.model.dto.TaskDto;

import java.util.List;

public interface TaskService {
    void createTasks (MatrixDto matrixDto);
    List <TaskDto> getTasks ();
}
