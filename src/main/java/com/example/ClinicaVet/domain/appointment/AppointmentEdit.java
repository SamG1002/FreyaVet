package com.example.ClinicaVet.domain.appointment;

import com.example.ClinicaVet.domain.client.Client;
import com.example.ClinicaVet.domain.doctor.Doctor;
import com.example.ClinicaVet.domain.pet.Pet;
import com.example.ClinicaVet.domain.species.Species;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AppointmentEdit(
    @NotNull(message = "ID Appointment is mandatory")
    Long idappointment,
    String diagnosis_appointment ,
    LocalDate dt_appointment ,
    String obs_appointment ,
    Pet pet,
    Doctor doctor
   ) {
}


