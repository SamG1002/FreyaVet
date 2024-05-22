package com.example.ClinicaVet.domain.exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExamRepository extends JpaRepository<Exam, Long>  {

    @Query("SELECT e FROM Exam e JOIN FETCH e.appointment a JOIN FETCH a.pet p JOIN FETCH p.species s JOIN FETCH p.client c JOIN FETCH c.user uc JOIN FETCH a.doctor d JOIN FETCH d.specialty sp JOIN FETCH d.user u")
    List<Exam> FindAllExam();

    @Query("SELECT e FROM Exam e JOIN FETCH e.appointment a JOIN FETCH a.pet p JOIN FETCH p.species s JOIN FETCH p.client c JOIN FETCH c.user uc JOIN FETCH a.doctor d JOIN FETCH d.specialty sp JOIN FETCH d.user u where a.dt_appointment > CURRENT_DATE()")
    List<Exam> FindAllExamActive();
    @Query("SELECT e FROM Exam e JOIN FETCH e.appointment a JOIN FETCH a.pet p JOIN FETCH p.species s JOIN FETCH p.client c JOIN FETCH c.user uc JOIN FETCH a.doctor d JOIN FETCH d.specialty sp JOIN FETCH d.user u WHERE e.id = :idexam")
    Exam findExamByID(@Param("idexam") Long idexam);

}
