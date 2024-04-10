package com.example.ClinicaVet.domain.user;

import jakarta.validation.constraints.NotNull;

public record UserRegister(
    @NotNull(message = "Login is mandatory")
    String login,
    @NotNull(message = "Password is mandatory")
    String password
   ) {
}


