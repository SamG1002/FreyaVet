package com.example.ClinicaVet.controller;

import com.example.ClinicaVet.domain.pet.*;
import com.example.ClinicaVet.domain.service.PetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetRepository repository;

    @Autowired
    private PetService petService;

    @GetMapping
    public List<Pet> getAllPetsActive() {
        return repository.findAllPetWithUserActive();
    }

    @GetMapping("/all")
    public List<Pet> getAllPets() {
        return repository.findAllPets();
    }

    @GetMapping("{id}")
    public ResponseEntity FindPetByID(@PathVariable Long id){
        return ResponseEntity.ok(
                new PetDetails(repository.findPetsByID(id))
        );
    }

    @PostMapping
    @Transactional
    public ResponseEntity RegisterPet(@RequestBody @Valid PetRegister data, UriComponentsBuilder uriBuilder){
        var pet = petService.savePet(data);
        var uri = uriBuilder.path("/pet/{id}").buildAndExpand(pet.getIdpet()).toUri();
        return ResponseEntity.created(uri).body(pet);
    }

    @Transactional
    @PutMapping
    public ResponseEntity EditPet(@RequestBody @Valid PetEdit data, UriComponentsBuilder uriBuilder){
        var pet = repository.findPetsByID(data.idpet());
        pet.update(data);
        return ResponseEntity.ok(new PetDetails(pet));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity DeletePet(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
