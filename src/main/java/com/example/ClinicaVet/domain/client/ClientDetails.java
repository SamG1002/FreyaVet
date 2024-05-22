package com.example.ClinicaVet.domain.client;

import com.example.ClinicaVet.domain.user.User;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ClientDetails(
        @NotNull
        Long idclient,
        @NotNull
        String name_client,
        @NotNull
        String cpf_client,
        String rg_client,
        String email_client,
        LocalDate dt_birth,
        @NotNull
        User user


) {
        public ClientDetails(Client client) {
                this(client.getIdclient(), client.getName_client(), client.getCpf_client(), client.getRg_client(), client.getEmail_client(), client.getDt_birth(), client.getUser());
        }
}
