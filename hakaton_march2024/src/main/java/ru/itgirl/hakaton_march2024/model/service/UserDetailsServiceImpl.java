package ru.itgirl.hakaton_march2024.model.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itgirl.hakaton_march2024.model.entity.Role;
import ru.itgirl.hakaton_march2024.model.entity.User;
import ru.itgirl.hakaton_march2024.model.repository.UserRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Try to find user by username {}", username);
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            log.info("User with username {} found", username);
            Set<GrantedAuthority> grantedRoles = new HashSet<>();
            for (Role role : user.get().getRoles()) {
                grantedRoles.add(new SimpleGrantedAuthority(role.getName()));
            }
            return new org.springframework.security.core.userdetails.User(user.get().getUsername(), user.get().getPassword(), grantedRoles);
        } else {
            log.error("User with username {} not found", username);
            throw new UsernameNotFoundException(username);
        }
    }
}
