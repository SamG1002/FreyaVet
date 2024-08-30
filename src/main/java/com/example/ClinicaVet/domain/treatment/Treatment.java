package com.example.ClinicaVet.domain.treatment;

import com.example.ClinicaVet.domain.appointment.Appointment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Table(name="treatment")
@Entity(name="Treatment")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Treatment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtreatment;
    private String desc_treatment;
    private LocalDate dt_start;
    private LocalDate dt_end;
    private Double prize;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idappointments")
    private Appointment appointment;

    public Treatment(TreatmentRegister data, Appointment appointment) {
        this.desc_treatment = data.desc_treatment();
        this.dt_start = data.dt_start();
        this.dt_end = data.dt_end();
        this.prize = data.prize();
        this.appointment = appointment;
    }


    public void update(TreatmentEdit data) {

        if(data.desc_treatment() != null) {
            this.desc_treatment = data.desc_treatment() ;
        }
        if(data.dt_start() != null) {
            this.dt_start = data.dt_start() ;
        }
        if(data.dt_end() != null) {
            this.dt_end = data.dt_end() ;
        }
        if(data.prize() != null) {
            this.prize = data.prize() ;
        }
        if(data.appointment() != null) {
            this.appointment = data.appointment();
        }

    }
}
