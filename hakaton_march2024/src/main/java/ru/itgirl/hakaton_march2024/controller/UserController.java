package ru.itgirl.hakaton_march2024.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itgirl.hakaton_march2024.model.dto.UserCreateDto;
import ru.itgirl.hakaton_march2024.model.dto.UserDto;
import ru.itgirl.hakaton_march2024.model.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    List<UserDto> getUsers() {
        return userService.findAllUsers();
    }

    @PostMapping("/sigh-up")
    void createNewUser(@RequestBody UserCreateDto userCreateDto) {
        userService.createUser(userCreateDto);
    }
}
