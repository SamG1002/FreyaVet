package com.example.ClinicaVet.domain.medication;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository<Medication, Long> {
    Medication findMedicationByIdmedication(long id);
}
