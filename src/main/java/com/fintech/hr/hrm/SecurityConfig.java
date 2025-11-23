package com.fintech.hr.hrm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.Customizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Disable CSRF but keep authentication
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()  // NOW requires authentication!
                )
                .httpBasic(Customizer.withDefaults());  // Use Basic Authentication
        return http.build();
    }
}