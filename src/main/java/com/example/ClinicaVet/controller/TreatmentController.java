package com.example.ClinicaVet.controller;

import com.example.ClinicaVet.domain.appointment.AppointmentRepository;
import com.example.ClinicaVet.domain.treatment.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/treatment")
public class TreatmentController {

    @Autowired
    private TreatmentRepository repository;
    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping
    public List<Treatment> getAllTreatmentsActive() {
        return repository.FindAllTreatmentActive();
    }

    @GetMapping("/all")
    public List<Treatment> getAllTreatments() {
        return repository.FindAllTreatment();
    }
    @GetMapping("{id}")
    public ResponseEntity FindTreatmentByID(@PathVariable Long id){
        return ResponseEntity.ok(
                new TreatmentDetails(repository.findTreatmentByID(id))
        );
    }
    @PostMapping
    @Transactional
    public ResponseEntity RegisterTreatment(@RequestBody @Valid TreatmentRegister data, UriComponentsBuilder uriBuilder){
        var appointment = appointmentRepository.findAppointmentByID(data.idappointment());
        var treatment = new Treatment(data, appointment);
        repository.save(treatment);

        var uri = uriBuilder.path("/treatment/{id}").buildAndExpand(treatment.getIdtreatment()).toUri();
        return ResponseEntity.created(uri).body(new TreatmentDetails(treatment));
    }

    @Transactional
    @PutMapping
    public ResponseEntity EditTreatment(@RequestBody @Valid TreatmentEdit data){
        var treatment = repository.findTreatmentByID(data.idtreatment());
        treatment.update(data);
        return ResponseEntity.ok(new TreatmentDetails(treatment));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity DeleteSpecialty(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
