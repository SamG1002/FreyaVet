package com.example.ClinicaVet.domain.exam;

import com.example.ClinicaVet.domain.appointment.Appointment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Table(name="exam")
@Entity(name="Exam")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idexam;
    private String name_exam;
    private LocalDate dt_request;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idappointments")
    private Appointment appointment;

    public Exam(ExamRegister data, Appointment appointment) {
        this.name_exam = data.name_exam();
        this.dt_request = data.dt_request();
        this.appointment = appointment;
    }


    public void update(ExamEdit data) {

        if(data.name_exam() != null) {
            this.name_exam = data.name_exam() ;
        }
        if(data.dt_request() != null) {
            this.dt_request = data.dt_request() ;
        }
        if(data.appointment() != null) {
            this.appointment = data.appointment();
        }

    }
}
