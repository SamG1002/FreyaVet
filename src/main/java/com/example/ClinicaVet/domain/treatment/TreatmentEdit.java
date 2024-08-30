package com.example.ClinicaVet.domain.treatment;

import com.example.ClinicaVet.domain.appointment.Appointment;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record TreatmentEdit(
    @NotNull
    Long idtreatment,
    String desc_treatment,
    LocalDate dt_start,
    LocalDate dt_end,
    Double prize,
    Appointment appointment
   ) {
}


