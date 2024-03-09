package ru.itgirl.hakaton_march2024.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
public class TaskDto {
    private String text;
    private String type;
    private Boolean done;
}
