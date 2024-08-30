package com.example.ClinicaVet.domain.treatment;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record TreatmentRegister(
    String desc_treatment,
    @NotNull(message = "date of start is mandatory")
    LocalDate dt_start,
    LocalDate dt_end,
    Double prize,
    @NotNull(message = "appointment is mandatory")
    Long idappointment
   ) {

}


