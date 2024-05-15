package com.example.ClinicaVet.controller;

import com.example.ClinicaVet.domain.appointment.*;
import com.example.ClinicaVet.domain.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentRepository repository;

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public List<Appointment> getAllAppointmentActive() {
        return repository.findAllAppointmentWithValidDate();
    }

    @GetMapping("/all")
    public List<Appointment> getAllAppointment() {
        return repository.findAllAppointment();
    }

    @GetMapping("{id}")
    public ResponseEntity FindAppointmentByID(@PathVariable Long id){
        return ResponseEntity.ok(
                new AppointmentDetails(repository.findAppointmentByID(id))
        );
    }

    @PostMapping
    @Transactional
    public ResponseEntity RegisterAppointment(@RequestBody @Valid AppointmentRegister data, UriComponentsBuilder uriBuilder){
        var appointment = appointmentService.saveAppointment(data);
        var uri = uriBuilder.path("/appointment/{id}").buildAndExpand(appointment.getIdappointment()).toUri();
        return ResponseEntity.created(uri).body(appointment);
    }

    @Transactional
    @PutMapping
    public ResponseEntity EditAppointment(@RequestBody @Valid AppointmentEdit data, UriComponentsBuilder uriBuilder){
        var appointment = repository.findAppointmentByID(data.idappointment());
        appointment.update(data);
        return ResponseEntity.ok(new AppointmentDetails(appointment));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity DeleteAppointment(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
