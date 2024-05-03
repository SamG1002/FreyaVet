package com.example.ClinicaVet.domain.service;

import com.example.ClinicaVet.domain.doctor.Doctor;
import com.example.ClinicaVet.domain.doctor.DoctorRegister;
import com.example.ClinicaVet.domain.doctor.DoctorRepository;
import com.example.ClinicaVet.domain.speciality.Specialty;
import com.example.ClinicaVet.domain.speciality.SpecialtyRepository;
import com.example.ClinicaVet.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class DoctorService {

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor saveDoctor(DoctorRegister data, User user, UriComponentsBuilder uriBuilder) {
        var specialty = specialtyRepository.findSpecialtyByIdspecialty(data.idspecialty());
        var doctor = new Doctor(data, user, specialty);
        return doctorRepository.save(doctor);
    }
}
