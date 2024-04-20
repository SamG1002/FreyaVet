package com.example.ClinicaVet.domain.speciality;

import jakarta.validation.constraints.NotNull;

public record SpecialtyRegister(
        @NotNull(message = "Name of Specialty is mandatory")
        String name_specialty,
        String description_specialty
) {
}
