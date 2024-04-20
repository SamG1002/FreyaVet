package com.example.ClinicaVet.domain.speciality;


import com.example.ClinicaVet.domain.user.UserEdit;
import com.example.ClinicaVet.domain.user.UserRegister;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name="specialty")
@Entity(name="Specialty")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idspecialty;
    private String name_specialty;
    private String description_specialty;

    public Specialty(SpecialtyRegister data){
        this.name_specialty = data.name_specialty();
        this.description_specialty = data.description_specialty();
    }

    public void update(SpecialtyEdit data) {
        System.out.println(data);
        if(data.name_specialty() != this.name_specialty && data.name_specialty() != null) {
            this.name_specialty = data.name_specialty();
        }
        if(data.description_specialty() != this.description_specialty) {
            this.description_specialty = data.description_specialty();
        }
    }


}
