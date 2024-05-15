package com.example.ClinicaVet.domain.appointment;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AppointmentRegister(
    @NotNull(message = "diagnosis is mandatory")
    String diagnosis_appointment ,
    @NotNull(message = "date appointment is mandatory")
    LocalDate dt_appointment ,
    String obs_appointment ,
    @NotNull(message = "ID Pet is mandatory")
    Long idpet,
    @NotNull(message = "ID Doctor is mandatory")
    Long iddoctor
   ) {

}


