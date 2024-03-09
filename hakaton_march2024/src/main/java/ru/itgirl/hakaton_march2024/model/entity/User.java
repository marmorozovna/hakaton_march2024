package ru.itgirl.hakaton_march2024.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Builder
@Table(name = "users")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String username;

    @Column (nullable = false)
    private String name;

    @Column (nullable = false)
    private String password;

    @Setter
    @ManyToMany
    @JoinTable(
            name = "user_role",
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private Set<Role> roles;

}