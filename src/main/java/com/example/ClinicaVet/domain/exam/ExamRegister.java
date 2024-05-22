package com.example.ClinicaVet.domain.exam;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record ExamRegister(
    @NotNull(message = "Name Exam is mandatory")
    String name_exam,
    LocalDate dt_request,
    Long idappointment
   ) {

}


