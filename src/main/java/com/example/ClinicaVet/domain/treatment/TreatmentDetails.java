package com.example.ClinicaVet.domain.treatment;

import com.example.ClinicaVet.domain.appointment.Appointment;
import com.example.ClinicaVet.domain.treatment.Treatment;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record TreatmentDetails(
        String desc_treatment,
        @NotNull(message = "date of start is mandatory")
        LocalDate dt_start,
        LocalDate dt_end,
        Double prize,
        @NotNull(message = "appointment is mandatory")
        Appointment appointment


) {
        public TreatmentDetails(Treatment treatment) {
                this(treatment.getDesc_treatment(), treatment.getDt_start(),treatment.getDt_end(), treatment.getPrize(), treatment.getAppointment());
        }
}
