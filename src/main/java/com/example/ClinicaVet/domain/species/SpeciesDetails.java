package com.example.ClinicaVet.domain.species;

import jakarta.validation.constraints.NotNull;

public record SpeciesDetails(
    @NotNull(message = "ID Species is mandatory")
    Long idspecies,
    String name_species,
    String obs_species
)
{

    public SpeciesDetails(Species species) {
        this(species.getIdspecies(), species.getName_species(), species.getObs_species());
    }
}
