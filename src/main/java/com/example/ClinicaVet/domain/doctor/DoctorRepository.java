package com.example.ClinicaVet.domain.doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long>  {

    @Query("SELECT d FROM Doctor d JOIN FETCH d.user JOIN FETCH d.specialty where d.user.blocked=false")
    List<Doctor> findAllWithUserActive();

    @Query("SELECT d FROM Doctor d JOIN FETCH d.user JOIN FETCH d.specialty")
    List<Doctor> findAllDoctors();

    @Query("SELECT d FROM Doctor d JOIN FETCH d.user JOIN FETCH d.specialty WHERE d.id = :iddoctor")
    Doctor findAllDoctorsByID(@Param("iddoctor") Long iddoctor);

}
