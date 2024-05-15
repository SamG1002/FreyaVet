package com.example.ClinicaVet.domain.appointment;

import com.example.ClinicaVet.domain.client.Client;
import com.example.ClinicaVet.domain.doctor.Doctor;
import com.example.ClinicaVet.domain.pet.Pet;
import com.example.ClinicaVet.domain.species.Species;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AppointmentDetails(
        @NotNull
        Long idappointment,
        @NotNull
        String diagnosis_appointment ,
        @NotNull
        LocalDate dt_appointment ,
        String obs_appointment ,
        @NotNull
        Pet pet,
        @NotNull
        Doctor doctor

) {
        public AppointmentDetails(Appointment appointment) {
                this(appointment.getIdappointment(), appointment.getDiagnosis_appointment(), appointment.getDt_appointment(), appointment.getObs_appointment(), appointment.getPet(), appointment.getDoctor());
        }
}
