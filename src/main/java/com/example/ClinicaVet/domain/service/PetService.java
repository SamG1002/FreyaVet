package com.example.ClinicaVet.domain.service;

import com.example.ClinicaVet.domain.client.ClientRepository;
import com.example.ClinicaVet.domain.pet.Pet;
import com.example.ClinicaVet.domain.pet.PetRegister;
import com.example.ClinicaVet.domain.pet.PetRepository;
import com.example.ClinicaVet.domain.species.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    @Autowired
    private SpeciesRepository specialtyRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PetRepository petRepository;

    public Pet savePet(PetRegister data) {
        var specialty = specialtyRepository.findSpeciesByIdspecies(data.idspecies());
        var client = clientRepository.findClientByID(data.idclient());
        var pet = new Pet(data, specialty, client);
        return petRepository.save(pet);
    }
}
