package com.example.ClinicaVet.domain.result_exam;

import com.example.ClinicaVet.domain.exam.Exam;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Table(name="result_exam")
@Entity(name="Result_exam")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Result_exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idresult_exam;
    private String name_result_exam;
    private String desc_result_exam;
    private LocalDate dt_result_exam;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idexam")
    private Exam exam;

    public Result_exam(Result_examRegister data, Exam exam) {
        this.name_result_exam = data.name_result_exam();
        this.desc_result_exam = data.desc_result_exam();
        this.dt_result_exam = data.dt_result_exam();
        this.exam = exam;
    }


    public void update(Result_examEdit data) {

        if(data.name_result_exam() != null) {
            this.name_result_exam = data.name_result_exam() ;
        }
        if(data.desc_result_exam() != null) {
            this.desc_result_exam = data.desc_result_exam() ;
        }
        if(data.dt_result_exam() != null) {
            this.dt_result_exam = data.dt_result_exam() ;
        }
        if(data.exam() != null) {
            this.exam = data.exam();
        }

    }
}
