package com.example.ClinicaVet.domain.user;

import jakarta.validation.constraints.NotNull;

public record UserEdit(
        @NotNull

        Long    iduser

        , String  password
        , String  acess_level
        , boolean blocked
        , boolean change_password
        , boolean two_steps
) {
}
