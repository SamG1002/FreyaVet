package com.example.ClinicaVet.domain.species;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeciesRepository extends JpaRepository<Species, Long> {
    Species findSpeciesByIdspecies(long id);
}
