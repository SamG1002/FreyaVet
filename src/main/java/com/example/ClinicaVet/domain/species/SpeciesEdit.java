package com.example.ClinicaVet.domain.species;

import jakarta.validation.constraints.NotNull;

public record SpeciesEdit(
    @NotNull(message = "ID Species is mandatory")
    Long idspecies,
    String name_species,
    String obs_species
) {

}

