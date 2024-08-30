package com.example.ClinicaVet.domain.treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TreatmentRepository extends JpaRepository<Treatment, Long>  {

    @Query("SELECT t FROM Treatment t JOIN FETCH t.appointment a JOIN FETCH a.pet p JOIN FETCH p.species s JOIN FETCH p.client c JOIN FETCH c.user uc JOIN FETCH a.doctor d JOIN FETCH d.specialty sp JOIN FETCH d.user u")
    List<Treatment> FindAllTreatment();

    @Query("SELECT t FROM Treatment t JOIN FETCH t.appointment a JOIN FETCH a.pet p JOIN FETCH p.species s JOIN FETCH p.client c JOIN FETCH c.user uc JOIN FETCH a.doctor d JOIN FETCH d.specialty sp JOIN FETCH d.user u where a.dt_appointment > CURRENT_DATE()")
    List<Treatment> FindAllTreatmentActive();
    @Query("SELECT t FROM Treatment t JOIN FETCH t.appointment a JOIN FETCH a.pet p JOIN FETCH p.species s JOIN FETCH p.client c JOIN FETCH c.user uc JOIN FETCH a.doctor d JOIN FETCH d.specialty sp JOIN FETCH d.user u WHERE t.id = :idtreatment")
    Treatment findTreatmentByID(@Param("idtreatment") Long idtreatment);

}
