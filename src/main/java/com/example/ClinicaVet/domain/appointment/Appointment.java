package com.example.ClinicaVet.domain.appointment;

import com.example.ClinicaVet.domain.doctor.Doctor;
import com.example.ClinicaVet.domain.pet.Pet;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name="appointment")
@Entity(name="Appointment")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idappointment;
    private String diagnosis_appointment ;
    private LocalDate dt_appointment ;
    private String obs_appointment ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idpet")
    private Pet pet ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iddoctor")
    private Doctor doctor;

    public Appointment(AppointmentRegister data, Pet pet, Doctor doctor) {
        this.diagnosis_appointment = data.diagnosis_appointment();
        this.dt_appointment = data.dt_appointment();
        this.obs_appointment = data.obs_appointment();
        this.pet = pet;
        this.doctor = doctor;
    }

    public void update(AppointmentEdit data) {

        if(data.diagnosis_appointment() != null) {
            this.diagnosis_appointment = data.diagnosis_appointment() ;
        }
        if(data.dt_appointment() != null) {
            this.dt_appointment = data.dt_appointment() ;
        }
        if(data.obs_appointment() != null) {
            this.obs_appointment = data.obs_appointment() ;
        }
        if(data.pet() != null) {
            this.pet = data.pet();
        }
        if(data.doctor() != null) {
            this.doctor = data.doctor();
        }

    }
}
