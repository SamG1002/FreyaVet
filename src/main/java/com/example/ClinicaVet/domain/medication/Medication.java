package com.example.ClinicaVet.domain.medication;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="medication")
@Entity(name="Medication")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idmedication;
    private String name_medication;
    private Double prize;

    public Medication(MedicationRegister data){
        this.name_medication = data.name_medication();
        this.prize = data.prize();
    }

    public void update(MedicationEdit data) {
        System.out.println(data);
        if(data.name_medication() != this.name_medication && data.name_medication() != null) {
            this.name_medication = data.name_medication();
        }
        if(data.prize() != this.prize) {
            this.prize = data.prize();
        }
    }


}
