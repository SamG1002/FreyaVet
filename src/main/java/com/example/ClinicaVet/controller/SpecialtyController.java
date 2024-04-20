package com.example.ClinicaVet.controller;

import com.example.ClinicaVet.domain.speciality.*;
import com.example.ClinicaVet.domain.user.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/specialty")
public class SpecialtyController {

    @Autowired
    private SpecialtyRepository repository;

    @GetMapping
    public List<Specialty> GetAllSpecialty(){
        return repository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity FindSpecialtyByID(@PathVariable Long id){
        return ResponseEntity.ok(
                new SpecialtyDetails(repository.getReferenceById(id))
        );
    }
    @PostMapping
    @Transactional
    public ResponseEntity RegisterSpecialty(@RequestBody @Valid SpecialtyRegister data, UriComponentsBuilder uriBuilder){
        var specialty = new Specialty(data);
        repository.save(specialty);
        var uri = uriBuilder.path("/user/{id}").buildAndExpand(specialty.getIdspecialty()).toUri();
        return ResponseEntity.created(uri).body(new SpecialtyDetails(specialty));
    }

    @Transactional
    @PutMapping
    public ResponseEntity EditSpecialty(@RequestBody @Valid SpecialtyEdit data){
        var specialty = repository.getReferenceById(data.idspecialty());
        specialty.update(data);
        return ResponseEntity.ok(new SpecialtyDetails(specialty));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity DeleteSpecialty(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
