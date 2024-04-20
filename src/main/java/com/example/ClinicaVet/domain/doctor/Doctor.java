package com.example.ClinicaVet.domain.doctor;

import com.example.ClinicaVet.domain.speciality.Specialty;
import com.example.ClinicaVet.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name="doctor")
@Entity(name="Doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iddoctor;
    private String name_doctor;
    private String cpf_doctor;
    private String rg_doctor;
    private String email_doctor;
    private LocalDate dt_birth;
    private String crm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idspecialty")
    private Specialty specialty;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iduser")
    private User user;

    public Doctor(DoctorRegister data, User user, Specialty specialty) {
        this.name_doctor = data.name_doctor();
        this.cpf_doctor = data.cpf_doctor();
        this.rg_doctor = data.rg_doctor();
        this.email_doctor = data.email_doctor();
        this.dt_birth = data.dt_birth();
        this.crm = data.crm();
        this.specialty = specialty;
        this.user = user;
    }


    public void update(DoctorEdit data) {


        if(data.name_doctor() != null) {
            this.name_doctor = data.name_doctor() ;
        }
        if(data.cpf_doctor() != null) {
            this.cpf_doctor = data.cpf_doctor() ;
        }
        if(data.rg_doctor() != null) {
            this.rg_doctor = data.rg_doctor() ;
        }
        if(data.email_doctor() != null) {
            this.email_doctor = data.email_doctor() ;
        }
        if(data.dt_birth() != null) {
            this.dt_birth = data.dt_birth() ;
        }
        if(data.crm() != null) {
            this.crm = data.crm() ;
        }
        if(data.user() != null) {
            this.user = data.user();
        }
        if(data.specialty() != null) {
            this.specialty = data.specialty();
        }

    }
}
