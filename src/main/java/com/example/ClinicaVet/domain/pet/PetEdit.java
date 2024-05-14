package com.example.ClinicaVet.domain.pet;

import com.example.ClinicaVet.domain.client.Client;
import com.example.ClinicaVet.domain.species.Species;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PetEdit(
    @NotNull(message = "ID Pet is mandatory")
    Long    idpet,
    String name_pet ,
    String age ,
    LocalDate dt_birth ,
    String size ,
    Species species,
    Client client
   ) {
}


