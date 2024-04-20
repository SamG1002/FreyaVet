package com.example.ClinicaVet.domain.user;

import jakarta.validation.constraints.NotNull;

public record UserEdit(
        @NotNull(message="ID User is mandatory")
        Long    iduser
        , String  password
        , String  acess_level
        , boolean blocked
        , boolean change_password
        , boolean two_steps
) {
}
