package com.example.ClinicaVet.domain.result_exam;

import com.example.ClinicaVet.domain.exam.Exam;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record Result_examDetails(
        @NotNull(message = "name is mandatory")
        String name_result_exam,
        String desc_result_exam,
        LocalDate dt_result_exam,
        @NotNull(message = "exam is mandatory")
        Exam exam


) {
        public Result_examDetails(Result_exam result_exam) {
                this(result_exam.getName_result_exam(), result_exam.getDesc_result_exam(), result_exam.getDt_result_exam(), result_exam.getExam());
        }
}
