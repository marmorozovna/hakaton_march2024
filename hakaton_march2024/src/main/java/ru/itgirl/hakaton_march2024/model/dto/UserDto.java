package ru.itgirl.hakaton_march2024.model.dto;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDto {

    @Setter
    String name;

    @Setter
    String login;

    @Setter
    List <String> role;
}
