package com.example.ClinicaVet.domain.result_exam;

import com.example.ClinicaVet.domain.exam.Exam;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record Result_examEdit(
    @NotNull
    Long idresult_exam,
    String name_result_exam,
    String desc_result_exam,
    LocalDate dt_result_exam,
    Exam exam
   ) {
}


