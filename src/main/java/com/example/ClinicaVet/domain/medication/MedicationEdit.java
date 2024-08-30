package com.example.ClinicaVet.domain.medication;

import jakarta.validation.constraints.NotNull;

public record MedicationEdit(
    @NotNull(message = "ID Medication is mandatory")
    Long idmedication,
    String name_medication,
    Double prize
) {

}

