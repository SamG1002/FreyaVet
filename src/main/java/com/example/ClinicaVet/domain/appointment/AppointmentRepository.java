package com.example.ClinicaVet.domain.appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>  {

    @Query("SELECT a FROM Appointment a JOIN FETCH a.pet p JOIN FETCH p.species s JOIN FETCH p.client c JOIN FETCH c.user uc JOIN FETCH a.doctor d JOIN FETCH d.specialty sp JOIN FETCH d.user u WHERE a.dt_appointment > CURRENT_DATE()")
    List<Appointment> findAllAppointmentWithValidDate();
    @Query("SELECT a FROM Appointment a JOIN FETCH a.pet p JOIN FETCH p.species s JOIN FETCH p.client c JOIN FETCH c.user uc JOIN FETCH a.doctor d JOIN FETCH d.specialty sp JOIN FETCH d.user u")
    List<Appointment> findAllAppointment();
    @Query("SELECT a FROM Appointment a JOIN FETCH a.pet p JOIN FETCH p.species s JOIN FETCH p.client c JOIN FETCH c.user uc JOIN FETCH a.doctor d JOIN FETCH d.specialty sp JOIN FETCH d.user u WHERE a.id = :idappointment")
    Appointment findAppointmentByID(@Param("idappointment") Long idappointment);

}
