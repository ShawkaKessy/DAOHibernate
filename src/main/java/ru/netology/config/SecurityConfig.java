package ru.netology.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/persons/by-city").permitAll()  // Открытый эндпоинт
                        .anyRequest().authenticated()  // Остальные требуют авторизации
                )
                .formLogin(form -> form.defaultSuccessUrl("/persons/by-city", true))  // Форма логина Spring
                .logout(logout -> logout.logoutSuccessUrl("/")); // Выход из системы

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")  // Имя пользователя
                .password("password")  // Пароль
                .roles("USER")  // Роль
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}
