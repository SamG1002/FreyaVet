package com.example.ClinicaVet.domain.client;

import com.example.ClinicaVet.domain.user.UserRegister;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public record ClientRegister(
    @NotNull(message = "Name is mandatory")
    String name_client,
    @NotNull(message = "CPF is mandatory")
//    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "Invalid CPF format")
    String cpf_client,
    String rg_client,
    String email_client,
    LocalDate dt_birth
   ) {

    public UserRegister CreateUser(){
        return new UserRegister(this.cpf_client, this.dt_birth.format(DateTimeFormatter.ofPattern("ddMMuuuu")));
    }
}


