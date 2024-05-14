package com.example.ClinicaVet.domain.pet;

import com.example.ClinicaVet.domain.client.Client;
import com.example.ClinicaVet.domain.species.Species;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name="pet")
@Entity(name="Pet")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpet;
    private String name_pet ;
    private String age ;
    private LocalDate dt_birth ;
    private String size ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idspecies")
    private Species species ;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idclient")
    private Client client;

    public Pet(PetRegister data, Species species, Client client) {
        this.name_pet = data.name_pet();
        this.age = data.age();
        this.dt_birth = data.dt_birth();
        this.size = data.size();
        this.species = species;
        this.client = client;
    }


    public void update(PetEdit data) {


        if(data.name_pet() != null) {
            this.name_pet = data.name_pet() ;
        }
        if(data.age() != null) {
            this.age = data.age() ;
        }
        if(data.size() != null) {
            this.size = data.size() ;
        }
        if(data.dt_birth() != null) {
            this.dt_birth = data.dt_birth() ;
        }
        if(data.species() != null) {
            this.species = data.species();
        }
        if(data.client() != null) {
            this.client = data.client();
        }

    }
}
