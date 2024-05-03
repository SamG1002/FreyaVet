package com.example.ClinicaVet.domain.species;

import jakarta.validation.constraints.NotNull;

public record SpeciesRegister(
        @NotNull(message = "Name of Specialty is mandatory")
        String name_species,
        String obs_species
) {
}
