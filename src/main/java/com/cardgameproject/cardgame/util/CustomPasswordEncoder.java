package com.cardgameproject.cardgame.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
@Getter
@Setter
@Component
public class CustomPasswordEncoder {
    private PasswordEncoder passwordEncoder;
    public CustomPasswordEncoder() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }
}
