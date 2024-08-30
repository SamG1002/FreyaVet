package com.example.ClinicaVet.domain.result_exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Result_examRepository extends JpaRepository<Result_exam, Long>  {

    @Query("SELECT r FROM Result_exam r JOIN FETCH r.exam e JOIN FETCH e.appointment a JOIN FETCH a.pet p JOIN FETCH p.species s JOIN FETCH p.client c JOIN FETCH c.user uc JOIN FETCH a.doctor d JOIN FETCH d.specialty sp JOIN FETCH d.user u")
    List<Result_exam> FindAllResult_exam();

    @Query("SELECT r FROM Result_exam r JOIN FETCH r.exam e JOIN FETCH e.appointment a JOIN FETCH a.pet p JOIN FETCH p.species s JOIN FETCH p.client c JOIN FETCH c.user uc JOIN FETCH a.doctor d JOIN FETCH d.specialty sp JOIN FETCH d.user u where a.dt_appointment > CURRENT_DATE()")
    List<Result_exam> FindAllResult_examActive();
    @Query("SELECT r FROM Result_exam r JOIN FETCH r.exam e JOIN FETCH e.appointment a JOIN FETCH a.pet p JOIN FETCH p.species s JOIN FETCH p.client c JOIN FETCH c.user uc JOIN FETCH a.doctor d JOIN FETCH d.specialty sp JOIN FETCH d.user u WHERE r.id = :idResult_exam")
    Result_exam findResult_examByID(@Param("idResult_exam") Long idResult_exam);

}
