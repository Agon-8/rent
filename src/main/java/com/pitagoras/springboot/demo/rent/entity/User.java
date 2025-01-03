package com.pitagoras.springboot.demo.rent.entity;

import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Table(name = "users")
public class User {


    private int userId;
    private String name;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Private constructor to enforce controlled creation
    private User() {
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    // Builder pattern for controlled object creation
    public static class Builder {
        private final User users;

        public Builder() {
            users = new User();
        }

        public Builder userId(int userId) {
            users.setUserId(userId);
            return this;
        }

        public Builder name(String name) {
            users.setName(name);
            return this;
        }

        public Builder email(String email) {
            users.setEmail(email);
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            users.setCreatedAt(createdAt);
            return this;
        }

        public Builder updatedAt(LocalDateTime updatedAt) {
            users.setUpdatedAt(updatedAt);
            return this;
        }

        public User build() {
            return users;
        }
    }
}
