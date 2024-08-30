package com.example.ClinicaVet.domain.medication;

import jakarta.validation.constraints.NotNull;

public record MedicationRegister(
        @NotNull(message = "Name of Specialty is mandatory")
        String name_medication,
        Double prize
) {
}
