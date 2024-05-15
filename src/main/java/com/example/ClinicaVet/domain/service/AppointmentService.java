package com.example.ClinicaVet.domain.service;

import com.example.ClinicaVet.domain.appointment.Appointment;
import com.example.ClinicaVet.domain.appointment.AppointmentRegister;
import com.example.ClinicaVet.domain.appointment.AppointmentRepository;
import com.example.ClinicaVet.domain.doctor.DoctorRepository;
import com.example.ClinicaVet.domain.pet.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment saveAppointment(AppointmentRegister data) {
        var doctor = doctorRepository.findDoctorByID(data.iddoctor());
        var pet = petRepository.findPetsByID(data.idpet());
        var appointment = new Appointment(data, pet, doctor);
        return appointmentRepository.save(appointment);
    }
}
