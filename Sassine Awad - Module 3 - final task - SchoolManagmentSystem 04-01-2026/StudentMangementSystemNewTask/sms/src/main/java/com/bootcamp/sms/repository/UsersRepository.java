package com.bootcamp.sms.repository;

import com.bootcamp.sms.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {

    // Checks if a user exists by username (Used by DataInitializer)
    boolean existsByUsername(String username);

    // Finds a user by username (Used by CustomUserDetailsService)
    // Spring Data JPA automatically implements this method for you.
    Optional<Users> findByUsername(String username);

}