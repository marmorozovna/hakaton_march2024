package ru.itgirl.hakaton_march2024.model.service;

import ru.itgirl.hakaton_march2024.model.dto.UserCreateDto;
import ru.itgirl.hakaton_march2024.model.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAllUsers ();
    void createUser(UserCreateDto userCreateDto);
}
