package com.example.ClinicaVet.domain.exam;

import com.example.ClinicaVet.domain.appointment.Appointment;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ExamDetails(
        @NotNull
        Long    idexam,
        String name_exam,
        LocalDate dt_request,
        Appointment appointment


) {
        public ExamDetails(Exam exam) {
                this(exam.getIdexam(), exam.getName_exam(), exam.getDt_request(), exam.getAppointment());
        }
}
