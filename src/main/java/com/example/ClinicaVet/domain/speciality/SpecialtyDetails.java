package com.example.ClinicaVet.domain.speciality;

public record SpecialtyDetails(
        Long idspecialty,
        String name_specialty,
        String description_specialty
) {
    public SpecialtyDetails(Specialty specialty) {
        this(specialty.getIdspecialty(), specialty.getName_specialty(), specialty.getDescription_specialty());
    }
}
