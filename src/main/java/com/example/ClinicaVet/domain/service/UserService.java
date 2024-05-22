package com.example.ClinicaVet.domain.service;

import com.example.ClinicaVet.controller.UserController;
import com.example.ClinicaVet.domain.client.ClientRepository;
import com.example.ClinicaVet.domain.doctor.DoctorRepository;
import com.example.ClinicaVet.domain.user.User;
import com.example.ClinicaVet.domain.user.UserDetails;
import com.example.ClinicaVet.domain.user.UserRegister;
import com.example.ClinicaVet.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class UserService {
    @Autowired
    private UserController userController;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private DoctorRepository doctorRepository;


    @Transactional
    public User registerUser(UserRegister data, UriComponentsBuilder uriBuilder) {
        ResponseEntity <UserDetails> userResponse = userController.RegisterUser(data, uriBuilder);
        var iduser = userResponse.getBody().iduser();
        return userRepository.getReferenceById(iduser);
    }

    public ResponseEntity deleteUserByID(Long iduser){
        return userController.DeleteLogical(iduser);
    }
}
