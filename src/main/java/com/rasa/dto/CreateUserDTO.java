package com.rasa.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


public record CreateUserDTO(@NotNull(message = "Username cannot be null") String username, @Email(message = "Please enter a valid email") String email) {}
