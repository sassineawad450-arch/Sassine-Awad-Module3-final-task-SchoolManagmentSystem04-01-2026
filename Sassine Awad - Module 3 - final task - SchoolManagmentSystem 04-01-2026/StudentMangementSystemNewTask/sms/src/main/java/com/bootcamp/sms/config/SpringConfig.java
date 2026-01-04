package com.bootcamp.sms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.thymeleaf.extras.springsecurity6.dialect.SpringSecurityDialect;

@Configuration
@EnableWebSecurity
public class SpringConfig {

    // Inject your CustomUserDetailsService to load users from the database
    @Autowired
    private CustomUserDetailsService userDetailsService;

    // Paths that do NOT require login
    private static final String[] PUBLIC_PATH = {
            "/login",
            "/css/**",
            "/images/**",
            "/js/**",
            "/error"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(PUBLIC_PATH).permitAll()
                        .anyRequest().authenticated()
                )
                // CRITICAL: This tells Spring Security to use your Database Users
                .userDetailsService(userDetailsService)
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login") // This must match the <form th:action="@{/login}">
                        .defaultSuccessUrl("/dashboard", true) // The 'true' forces it to go to dashboard
                        .permitAll()

                )

                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // CRITICAL: This fixes the "500 Internal Server Error" on the login page
    // It allows Thymeleaf to understand ${_csrf} and sec:authorize tags
    @Bean
    public SpringSecurityDialect springSecurityDialect() {
        return new SpringSecurityDialect();
    }
}