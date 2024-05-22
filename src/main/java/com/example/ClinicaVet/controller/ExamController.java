package com.example.ClinicaVet.controller;

import com.example.ClinicaVet.domain.appointment.AppointmentRepository;
import com.example.ClinicaVet.domain.exam.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    private ExamRepository repository;
    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping
    public List<Exam> getAllExamsActive() {
        return repository.FindAllExamActive();
    }

    @GetMapping("/all")
    public List<Exam> getAllExams() {
        return repository.FindAllExam();
    }
    @GetMapping("{id}")
    public ResponseEntity FindExamByID(@PathVariable Long id){
        return ResponseEntity.ok(
                new ExamDetails(repository.findExamByID(id))
        );
    }
    @PostMapping
    @Transactional
    public ResponseEntity RegisterExam(@RequestBody @Valid ExamRegister data, UriComponentsBuilder uriBuilder){
        var appointment = appointmentRepository.findAppointmentByID(data.idappointment());
        var exam = new Exam(data, appointment);
        repository.save(exam);

        var uri = uriBuilder.path("/exam/{id}").buildAndExpand(exam.getIdexam()).toUri();
        return ResponseEntity.created(uri).body(new ExamDetails(exam));
    }

    @Transactional
    @PutMapping
    public ResponseEntity EditExam(@RequestBody @Valid ExamEdit data){
        var exam = repository.findExamByID(data.idexam());
        exam.update(data);
        return ResponseEntity.ok(new ExamDetails(exam));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity DeleteSpecialty(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
