package com.example.ClinicaVet.controller;

import com.example.ClinicaVet.domain.species.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/species")
public class SpeciesController {

    @Autowired
    private SpeciesRepository repository;

    @GetMapping
    public List<Species> GetAllSpecies(){
        return repository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity FindSpeciesByID(@PathVariable Long id){
        return ResponseEntity.ok(
                new SpeciesDetails(repository.getReferenceById(id))
        );
    }
    @PostMapping
    @Transactional
    public ResponseEntity RegisterSpecies(@RequestBody @Valid SpeciesRegister data, UriComponentsBuilder uriBuilder){
        var species = new Species(data);
        repository.save(species);
        var uri = uriBuilder.path("/user/{id}").buildAndExpand(species.getIdspecies()).toUri();
        return ResponseEntity.created(uri).body(new SpeciesDetails(species));
    }

    @Transactional
    @PutMapping
    public ResponseEntity EditSpecies(@RequestBody @Valid SpeciesEdit data){
        var species = repository.getReferenceById(data.idspecies());
        species.update(data);
        return ResponseEntity.ok(new SpeciesDetails(species));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity DeleteSpecies(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
