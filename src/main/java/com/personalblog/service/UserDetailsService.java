package com.personalblog.service;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    private final UserService userService;
    private final HttpSession session;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<com.personalblog.entity.User> optionalUser = userService.getByUsername(username);

        if (optionalUser.isPresent()) {
            session.setAttribute("user_session_id", optionalUser.get().getId());
            com.personalblog.entity.User user = optionalUser.get();
            return User.builder()
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .roles()
                    .build();
        } else {
            throw new UsernameNotFoundException("¡User not found!");
        }
    }
}
