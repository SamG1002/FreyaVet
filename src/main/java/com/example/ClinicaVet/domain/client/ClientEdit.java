package com.example.ClinicaVet.domain.client;

import com.example.ClinicaVet.domain.user.User;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ClientEdit(

    @NotNull(message = "ID CLient is mandatory")
    Long    idclient,
    String name_client,
    String cpf_client,
    String rg_client,
    String email_client,
    LocalDate dt_birth,
    User user
   ) {
}


