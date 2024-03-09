package ru.itgirl.hakaton_march2024.model.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Getter
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Setter
    private String text;

    @Column(nullable = false)
    @Setter
    private String type;

    @Column(nullable = false)
    @Setter
    private Boolean done;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
