package com.example.ClinicaVet.domain.client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long>  {

    @Query("SELECT c FROM Client c LEFT JOIN FETCH c.user")
    List<Client> findAllWithUser();

    @Query("SELECT c FROM Client c LEFT JOIN FETCH c.user where user.blocked=false")
    List<Client> findAllWithUserActive();

}
