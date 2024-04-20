package com.example.ClinicaVet.domain.doctor;

import com.example.ClinicaVet.domain.speciality.Specialty;
import com.example.ClinicaVet.domain.user.User;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DoctorEdit(

    @NotNull(message = "ID CLient is mandatory")
    Long    iddoctor,
    String name_doctor,
    String cpf_doctor,
    String rg_doctor,
    String email_doctor,
    LocalDate dt_birth,
    String crm,
    User user,
    Specialty specialty
   ) {
}


