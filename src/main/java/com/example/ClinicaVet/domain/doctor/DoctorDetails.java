package com.example.ClinicaVet.domain.doctor;

import com.example.ClinicaVet.domain.speciality.Specialty;
import com.example.ClinicaVet.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DoctorDetails(
        @NotNull
        Long iddoctor,
        @NotNull
        String name_doctor,
        @NotNull
        String cpf_doctor,
        String rg_doctor,
        String email_doctor,
        LocalDate dt_birth,
        String crm,
        @NotNull
        Specialty specialty,
        @NotNull
        User user

) {
        public DoctorDetails(Doctor doctor) {
                this(doctor.getIddoctor(), doctor.getName_doctor(), doctor.getCpf_doctor(), doctor.getRg_doctor(), doctor.getEmail_doctor(), doctor.getDt_birth(), doctor.getCrm(), doctor.getSpecialty(), doctor.getUser());
        }
}
