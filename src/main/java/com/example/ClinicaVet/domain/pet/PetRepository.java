package com.example.ClinicaVet.domain.pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long>  {

    @Query("SELECT p FROM Pet p JOIN FETCH p.species JOIN FETCH p.client c JOIN FETCH c.user u where u.blocked=false")
    List<Pet> findAllPetWithUserActive();

    @Query("SELECT p FROM Pet p JOIN FETCH p.species JOIN FETCH p.client c JOIN FETCH c.user u")
    List<Pet> findAllPets();

    @Query("SELECT p FROM Pet p JOIN FETCH p.species JOIN FETCH p.client c JOIN FETCH c.user u WHERE p.id = :idpet")
    Pet findPetsByID(@Param("idpet") Long idpet);

}
