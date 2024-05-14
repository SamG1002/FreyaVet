package com.example.ClinicaVet.domain.pet;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PetRegister(
    @NotNull(message = "Name is mandatory")
    String name_pet ,
    String age ,
    LocalDate dt_birth ,
    String size ,
    @NotNull(message = "ID Species is mandatory")
    Long idspecies,
    @NotNull(message = "ID Client is mandatory")
    Long idclient
   ) {

}


