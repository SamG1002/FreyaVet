package com.example.ClinicaVet.domain.species;

import jakarta.validation.constraints.NotNull;

public record SpecialtyEdit(
        @NotNull(message = "ID Specialty is mandatory")
        Long idspecialty,
        String name_specialty,
        String description_specialty
) {
}
