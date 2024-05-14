package com.example.ClinicaVet.domain.client;
import com.example.ClinicaVet.domain.doctor.Doctor;
import com.example.ClinicaVet.domain.speciality.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long>  {

    @Query("SELECT c FROM Client c JOIN FETCH c.user")
    List<Client> findAllWithUser();

    @Query("SELECT c FROM Client c JOIN FETCH c.user where user.blocked=false")
    List<Client> findAllWithUserActive();

    @Query("SELECT c FROM Client c JOIN FETCH c.user WHERE c.id = :idclient")
    Client findClientByID(@Param("idclient") Long idclient);

}
