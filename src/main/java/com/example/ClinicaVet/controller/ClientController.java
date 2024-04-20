package com.example.ClinicaVet.controller;

import com.example.ClinicaVet.domain.client.*;
import com.example.ClinicaVet.domain.service.UserService;
import com.example.ClinicaVet.domain.user.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserController userController;

    @Autowired
    private UserService UserService;


    @GetMapping
    public List<Client> getAllClientsActive() {
        return repository.findAllWithUserActive();
    }

    @GetMapping("/all")
    public List<Client> getAllClients() {
        return repository.findAllWithUser();
    }
    @GetMapping("{id}")
    public ResponseEntity FindClientByID(@PathVariable Long id){
        return ResponseEntity.ok(
                new ClientDetails(repository.getReferenceById(id))
        );
    }
    @PostMapping
    @Transactional
    public ResponseEntity RegisterClient(@RequestBody @Valid ClientRegister data, UriComponentsBuilder uriBuilder){
        UriComponentsBuilder uriBuilderUser = UriComponentsBuilder.fromPath("/user");
        var user = UserService.registerUser(data.CreateUser(), uriBuilderUser);
        Client client = new Client(data, user);
        repository.save(client);

        var uri = uriBuilder.path("/client/{id}").buildAndExpand(client.getIdclient()).toUri();
        return ResponseEntity.created(uri).body(new ClientDetails(client));
    }

    @Transactional
    @PutMapping
    public ResponseEntity EditClient(@RequestBody @Valid ClientEdit data){
        var client = repository.getReferenceById(data.idclient());
        client.update(data);
        return ResponseEntity.ok(new ClientDetails(client));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity DeleteLogical(@PathVariable Long id){
        ResponseEntity<ClientDetails> clientResponse = FindClientByID(id);
        var iduser = clientResponse.getBody().user().getIduser();

        var status = UserService.deleteUserByID(iduser).getStatusCode();
        return ResponseEntity.status(status).build();
    }
}
