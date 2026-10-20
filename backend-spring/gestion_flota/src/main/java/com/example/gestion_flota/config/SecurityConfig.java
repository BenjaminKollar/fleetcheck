package com.example.gestion_flota.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Deshabilitado para pruebas locales en postman/intellij
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**").permitAll()      // Permite el login libre
                        .requestMatchers("/api/vehiculos/**").permitAll() // Mantiene libre tu endpoint de vehículos
                        .anyRequest().authenticated()
                );
        return http.build();
    }
}