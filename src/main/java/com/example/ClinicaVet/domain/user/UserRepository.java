package com.example.ClinicaVet.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>  {
    List<User> findByBlockedFalse();

}
