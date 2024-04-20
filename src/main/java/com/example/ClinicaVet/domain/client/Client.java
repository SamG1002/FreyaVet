package com.example.ClinicaVet.domain.client;

import com.example.ClinicaVet.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Table(name="client")
@Entity(name="Client")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idclient;
    private String name_client;
    private String cpf_client;
    private String rg_client;
    private String email_client;
    private LocalDate dt_birth;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iduser")
    private User user;

    public Client(ClientRegister data, User user) {
        this.name_client = data.name_client();
        this.cpf_client = data.cpf_client();
        this.rg_client = data.rg_client();
        this.email_client = data.email_client();
        this.dt_birth = data.dt_birth();
        this.user = user;
    }


    public void update(ClientEdit data) {


        if(data.name_client() != null) {
            this.name_client = data.name_client() ;
        }
        if(data.cpf_client() != null) {
            this.cpf_client = data.cpf_client() ;
        }
        if(data.rg_client() != null) {
            this.cpf_client = data.rg_client() ;
        }
        if(data.email_client() != null) {
            this.email_client = data.email_client() ;
        }
        if(data.dt_birth() != null) {
            this.dt_birth = data.dt_birth() ;
        }
        if(data.user() != null) {
            this.user = data.user();
        }

    }
}
