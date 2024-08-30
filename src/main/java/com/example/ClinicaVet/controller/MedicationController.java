package com.example.ClinicaVet.controller;

import com.example.ClinicaVet.domain.medication.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/medication")
public class MedicationController {

    @Autowired
    private MedicationRepository repository;

    @GetMapping
    public List<Medication> GetAllMedication(){
        return repository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity FindMedicationByID(@PathVariable Long id){
        return ResponseEntity.ok(
                new MedicationDetails(repository.getReferenceById(id))
        );
    }
    @PostMapping
    @Transactional
    public ResponseEntity RegisterMedication(@RequestBody @Valid MedicationRegister data, UriComponentsBuilder uriBuilder){
        var medication = new Medication(data);
        repository.save(medication);
        var uri = uriBuilder.path("/user/{id}").buildAndExpand(medication.getIdmedication()).toUri();
        return ResponseEntity.created(uri).body(new MedicationDetails(medication));
    }

    @Transactional
    @PutMapping
    public ResponseEntity EditMedication(@RequestBody @Valid MedicationEdit data){
        var medication = repository.getReferenceById(data.idmedication());
        medication.update(data);
        return ResponseEntity.ok(new MedicationDetails(medication));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity DeleteMedication(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
