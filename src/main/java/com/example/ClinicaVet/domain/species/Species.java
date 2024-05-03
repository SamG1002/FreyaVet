package com.example.ClinicaVet.domain.species;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="species")
@Entity(name="Species")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idspecies;
    private String name_species;
    private String obs_species;

    public Species(SpeciesRegister data){
        this.name_species = data.name_species();
        this.obs_species = data.obs_species();
    }

    public void update(SpeciesEdit data) {
        System.out.println(data);
        if(data.name_species() != this.name_species && data.name_species() != null) {
            this.name_species = data.name_species();
        }
        if(data.obs_species() != this.obs_species) {
            this.obs_species = data.obs_species();
        }
    }


}
