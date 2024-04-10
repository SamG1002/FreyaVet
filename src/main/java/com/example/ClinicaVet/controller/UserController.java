package com.example.ClinicaVet.controller;

import com.example.ClinicaVet.domain.user.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> GetAllUserActive() { return repository.findByBlockedFalse(); }

    @RequestMapping("/all")
    @GetMapping
    public List<User> GetAllUser(){
        return repository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity FindUserByID(@PathVariable Long id){
        return ResponseEntity.ok(
                new UserDetails(repository.getReferenceById(id))
        );
    }
    @PostMapping
    @Transactional
    public ResponseEntity RegisterUser(@RequestBody @Valid UserRegister data, UriComponentsBuilder uriBuilder){
        var user = new User(data);
        repository.save(user);
        var uri = uriBuilder.path("/user/{id}").buildAndExpand(user.getIduser()).toUri();
        return ResponseEntity.created(uri).body(new UserDetails(user));
    }

    @Transactional
    @PutMapping
    public ResponseEntity EditUser(@RequestBody @Valid UserEdit data){
        var user = repository.getReferenceById(data.iduser());
        user.update(data);
        return ResponseEntity.ok(new UserDetails(user));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity DeleteLogical(@PathVariable Long id){
        var user = repository.getReferenceById(id);
        user.delete(id);
        return ResponseEntity.noContent().build();
    }
}
