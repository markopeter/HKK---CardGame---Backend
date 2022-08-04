package com.cardgameproject.cardgame.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthCredentialRequest {
    private String username;
    private String password;
}
