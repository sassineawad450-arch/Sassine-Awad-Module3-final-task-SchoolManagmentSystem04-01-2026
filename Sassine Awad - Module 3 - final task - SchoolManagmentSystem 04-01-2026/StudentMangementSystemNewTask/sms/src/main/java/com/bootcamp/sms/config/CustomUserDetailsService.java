package com.bootcamp.sms.config;

import com.bootcamp.sms.model.Users;
import com.bootcamp.sms.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Autowired
    public CustomUserDetailsService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 1. Find the user in the database
        Users users = usersRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        // 2. Build the Spring Security User object
        return User.builder()
                .username(users.getUsername())
                .password(users.getPassword())
                .roles("ADMIN")          // Grants ADMIN permissions to access the dashboard
                .disabled(!users.isActive()) // Checks if 'active' column in DB is true
                .build();
    }
}