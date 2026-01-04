package com.bootcamp.sms.config;

import com.bootcamp.sms.model.Users;
import com.bootcamp.sms.repository.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataIntializer {

    @Bean
    CommandLineRunner loadSampleData(UsersRepository usersRepository,
                                     PasswordEncoder passwordEncoder) {

        return args -> {
            // 1. Log that the process has started
            System.out.println("DEBUG: Checking database for Admin user...");

            // 2. Check if the user already exists to avoid duplicate errors
            if (!usersRepository.existsByUsername("Admin")) {

                System.out.println("DEBUG: Admin user not found. Creating default account...");

                Users adminUser = new Users();
                adminUser.setUsername("Admin");

                // 3. Encrypt the password using BCrypt
                adminUser.setPassword(passwordEncoder.encode("admin123"));

                // 4. Set all the necessary flags based on your Users model
                adminUser.setActive(true);
                adminUser.setEnable(true);
                adminUser.setRole("ADMIN");

                // 5. Save to the MySQL database
                usersRepository.save(adminUser);

                System.out.println("SUCCESS: Admin user 'Admin' with password 'admin123' created successfully!");
            } else {
                System.out.println("INFO: Admin user already exists in the database. No action taken.");
            }
        };
    }
}