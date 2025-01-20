package com.pitagoras.springboot.demo.rent.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class RentSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}$2a$12$hcGr1oIw8Z2LUHeoAnSA9OnuJk22TkkmsWveV2jsRgaw66zSTfFsy")
                .roles("EMPLOYEE")
                .build();
        UserDetails mary = User.builder()
                .username("mary")
                .password("{bcrypt}$2a$12$hcGr1oIw8Z2LUHeoAnSA9OnuJk22TkkmsWveV2jsRgaw66zSTfFsy")
                .roles("EMPLOYEE", "MANAGER")
                .build();
        UserDetails susan = User.builder()
                .username("susan")
                .password("{bcrypt}$2a$12$hcGr1oIw8Z2LUHeoAnSA9OnuJk22TkkmsWveV2jsRgaw66zSTfFsy")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();
        return new InMemoryUserDetailsManager(john, mary, susan);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/cars/list").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/cars/find/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/cars").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/cars/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/cars/**").hasRole("ADMIN"));

        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

}
