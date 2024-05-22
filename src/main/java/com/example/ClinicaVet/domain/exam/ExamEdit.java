package com.example.ClinicaVet.domain.exam;

import com.example.ClinicaVet.domain.appointment.Appointment;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record ExamEdit(

    @NotNull(message = "ID Exam is mandatory")
    Long    idexam,
    String name_exam,
    LocalDate dt_request,
    Appointment appointment
   ) {
}


