package com.example.ClinicaVet.controller;

import com.example.ClinicaVet.domain.doctor.*;
import com.example.ClinicaVet.domain.service.DoctorService;
import com.example.ClinicaVet.domain.service.UserService;
import com.example.ClinicaVet.domain.speciality.Specialty;
import com.example.ClinicaVet.domain.speciality.SpecialtyRepository;
import com.example.ClinicaVet.domain.user.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public List<Doctor> getAllDoctorsActive() {
        return repository.findAllWithUserActive();
    }

    @GetMapping("/all")
    public List<Doctor> getAllDoctors() {
        return repository.findAllDoctors();
    }

    @GetMapping("{id}")
    public ResponseEntity FindDoctorByID(@PathVariable Long id){
        return ResponseEntity.ok(
                new DoctorDetails(repository.findAllDoctorsByID(id))
        );
    }

    @PostMapping
    @Transactional
    public ResponseEntity RegisterDoctor(@RequestBody @Valid DoctorRegister data, UriComponentsBuilder uriBuilder){
        UriComponentsBuilder uriBuilderUser = UriComponentsBuilder.fromPath("/user");
        var user = userService.registerUser(data.CreateUser(), uriBuilderUser);
        var doctor = doctorService.saveDoctor(data, user, uriBuilderUser);
        var uri = uriBuilder.path("/doctor/{id}").buildAndExpand(doctor.getIddoctor()).toUri();
        return ResponseEntity.created(uri).body(doctor);
    }

    @Transactional
    @PutMapping
    public ResponseEntity EditDoctor(@RequestBody @Valid DoctorEdit data, UriComponentsBuilder uriBuilder){
        var doctor = repository.findAllDoctorsByID(data.iddoctor());
        doctor.update(data);
        return ResponseEntity.ok(new DoctorDetails(doctor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity DeleteLogical(@PathVariable Long id){
        ResponseEntity<DoctorDetails> doctorResponse = FindDoctorByID(id);
        var iduser = doctorResponse.getBody().user().getIduser();

        var status = userService.deleteUserByID(iduser).getStatusCode();
        return ResponseEntity.status(status).build();
    }
}
