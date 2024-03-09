package ru.itgirl.hakaton_march2024.model.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
public class UserCreateDto {
    String name;
    String login;
    String password;
}
