package com.example.ClinicaVet.domain.doctor;

import com.example.ClinicaVet.domain.user.UserRegister;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public record DoctorRegister(
    @NotNull(message = "Name is mandatory")
    String name_doctor,
    @NotNull(message = "CPF is mandatory")
//    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "Invalid CPF format")
    String cpf_doctor,
    String rg_doctor,
    String email_doctor,
    LocalDate dt_birth,
    @NotNull(message = "CRM is mandatory")
//    @Pattern(regexp = "\\d{6}\\-\\d{1}", message = "Invalid CRM format")
    String crm,
    @NotNull(message = "ID Specialty is mandatory")
    Long idspecialty
   ) {

    public UserRegister CreateUser(){
        return new UserRegister(this.cpf_doctor, this.dt_birth.format(DateTimeFormatter.ofPattern("ddMMuuuu")));
    }
}


