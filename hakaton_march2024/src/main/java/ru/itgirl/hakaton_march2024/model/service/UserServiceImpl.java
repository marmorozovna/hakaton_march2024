package ru.itgirl.hakaton_march2024.model.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itgirl.hakaton_march2024.model.dto.UserCreateDto;
import ru.itgirl.hakaton_march2024.model.dto.UserDto;
import ru.itgirl.hakaton_march2024.model.entity.User;
import ru.itgirl.hakaton_march2024.model.repository.RoleRepository;
import ru.itgirl.hakaton_march2024.model.repository.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> UserDto.builder().name(user.getName()).login(user.getUsername())
                .role(user.getRoles().stream().map(role -> role.getName()).toList().stream().toList()).build()).toList();
    }

    public void createUser(UserCreateDto userCreateDto) {
        User user = userRepository.save(User.builder()
                        .name(userCreateDto.getName())
                        .password(bCryptPasswordEncoder.encode(userCreateDto.getPassword()))
                        .username(userCreateDto.getLogin())
                        .roles(Set.of(roleRepository.findByName("ROLE_USER").orElseThrow()))
                .build());
    }
}
