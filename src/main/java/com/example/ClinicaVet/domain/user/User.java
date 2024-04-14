package com.example.ClinicaVet.domain.user;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name="user")
@Entity(name="User")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long iduser;
    private String login;
    private String password;
    private String acess_level;
    private boolean blocked;
    private boolean change_password;
    private boolean two_steps;
    private LocalDateTime dt_create;
    private LocalDateTime last_acess;

    public User(UserRegister data) {

        this.login = data.login();
        this.password = data.password();
        this.acess_level = "";
        this.blocked = false;
        this.change_password = true;
        this.two_steps = false;
        this.last_acess = LocalDateTime.now();
        this.dt_create = LocalDateTime.now();
    }

    public void delete(Long id) {
        this.blocked = true;
    }

    public void update(UserEdit data) {
        if(data.password() != null) {
            this.password = data.password();
        }
        if(data.acess_level() != null) {
            this.acess_level = data.acess_level();
        }
        if(data.blocked() != this.blocked) {
            this.blocked = data.blocked();
        }
        if(data.change_password() != this.change_password) {
            this.change_password = data.change_password();
        }
        if(data.two_steps() != this.two_steps) {
            this.two_steps = data.two_steps();
        }
    }
}
