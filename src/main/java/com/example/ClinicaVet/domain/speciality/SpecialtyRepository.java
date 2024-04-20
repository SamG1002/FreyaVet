package com.example.ClinicaVet.domain.speciality;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {

    Specialty findSpecialtyByIdspecialty(long id);
}
