package com.proyecto.ecommerce.springecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringBootSecurityConfiguration {

    @Autowired
    private UserDetailsService userDetailService;
/*
    @Bean
    public BCryptPasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(SecurityFilterChain http) throws Exception {
        http.authorizeRequests().access((request, authentication) -> {
            if (request.getRequestURL().toString().startsWith("/administrador/") && !hasRole("ADMIN")) {
                throw new AccessDeniedException("You need to be an admin to access this page.");
            } else if (request.getRequestURL().toString().startsWith("/productos/") && !hasRole("ADMIN")) {
                throw new AccessDeniedException("You need to be an admin to access this page.");
            }
        })
                .formLogin()
                .loginPage("/usuario/login")
                .permitAll()
                .defaultSuccessUrl("/usuario/acceder");
        return http.build();
    } */
}