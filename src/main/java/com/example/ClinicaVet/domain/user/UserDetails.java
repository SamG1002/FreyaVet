package com.example.ClinicaVet.domain.user;

import java.time.LocalDateTime;

public record UserDetails(Long iduser, String login, String password, String acess_level, boolean blocked, boolean change_password, boolean two_steps, LocalDateTime last_acess, LocalDateTime dt_create) {

    public UserDetails(User user) {
        this(user.getIduser(), user.getLogin(), user.getPassword()
                , user.getAcess_level(), user.isBlocked(), user.isChange_password()
                , user.isTwo_steps(), user.getLast_acess(), user.getDt_create()
        );
    }
}
