package com.example.ClinicaVet.domain.service;

import com.example.ClinicaVet.controller.UserController;
import com.example.ClinicaVet.domain.client.Client;
import com.example.ClinicaVet.domain.client.ClientRegister;
import com.example.ClinicaVet.domain.client.ClientRepository;
import com.example.ClinicaVet.domain.user.UserDetails;
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

    @Transactional
    public Client registerClientAndUser(ClientRegister data, UriComponentsBuilder uriBuilder) {
        ResponseEntity <UserDetails> userResponse = userController.RegisterUser(data.CreateUser(), uriBuilder);
        var iduser = userResponse.getBody().iduser();
        var user = userRepository.getReferenceById(iduser);

        Client client = new Client(data, user);
        return clientRepository.save(client);
    }

    public ResponseEntity deleteUserByClient(Long iduser){
        return userController.DeleteLogical(iduser);
    }
}
