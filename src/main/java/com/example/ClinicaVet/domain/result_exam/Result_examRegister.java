package com.example.ClinicaVet.domain.result_exam;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

import com.example.ClinicaVet.domain.exam.Exam;

public record Result_examRegister(
    @NotNull(message = "name is mandatory")
    String name_result_exam,
    String desc_result_exam,
    LocalDate dt_result_exam,
    @NotNull(message = "exam is mandatory")
    Exam exam
   ) {

}


