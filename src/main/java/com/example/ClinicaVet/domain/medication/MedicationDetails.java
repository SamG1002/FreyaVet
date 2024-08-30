package com.example.ClinicaVet.domain.medication;

import jakarta.validation.constraints.NotNull;

public record MedicationDetails(
    @NotNull(message = "ID Medication is mandatory")
    Long idmedication,
    String name_medication,
    Double prize
)
{

    public MedicationDetails(Medication medication) {
        this(medication.getIdmedication(), medication.getName_medication(), medication.getPrize());
    }
}
