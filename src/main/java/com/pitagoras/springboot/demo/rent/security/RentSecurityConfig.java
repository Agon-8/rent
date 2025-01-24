package com.pitagoras.springboot.demo.rent.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class RentSecurityConfig {
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id,password,enabled from users where user_id = ?"
        );
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id,authority from authorities where user_id = ?"
        );
        return jdbcUserDetailsManager;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/cars/list").hasAnyRole("EMPLOYEE","MANAGER","ADMIN")
                        .requestMatchers(HttpMethod.GET, "/cars/find/").hasAnyRole("EMPLOYEE","MANAGER","ADMIN")
                        .requestMatchers(HttpMethod.POST, "/cars").hasAnyRole("MANAGER","ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/cars/").hasAnyRole("MANAGER","ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/cars/**").hasRole("ADMIN"));

        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf->csrf.disable());
        return http.build();
    }

}
