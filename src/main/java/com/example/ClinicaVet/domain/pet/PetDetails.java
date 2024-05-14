package com.example.ClinicaVet.domain.pet;

import com.example.ClinicaVet.domain.client.Client;
import com.example.ClinicaVet.domain.species.Species;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PetDetails(
        @NotNull
        Long    idpet,
        String name_pet ,
        String age ,
        LocalDate dt_birth ,
        @NotNull
        Species species,
        @NotNull
        Client client

) {
        public PetDetails(Pet pet) {
                this(pet.getIdpet(), pet.getName_pet(), pet.getAge(), pet.getDt_birth(), pet.getSpecies(), pet.getClient());
        }
}
