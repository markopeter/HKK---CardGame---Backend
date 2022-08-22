package com.cardgameproject.cardgame.controller;

import com.cardgameproject.cardgame.dto.AuthCredentialsRequest;
import com.cardgameproject.cardgame.entity.UserEntity;
import com.cardgameproject.cardgame.util.JwtUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080", "https://fast-dusk-75315.herokuapp.com"}, allowCredentials = "true")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }


    @PostMapping("login")
    public ResponseEntity <?> login(@RequestBody (required = false) AuthCredentialsRequest request){
        try{
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(), request.getPassword()));
            UserEntity user = (UserEntity) authenticate.getPrincipal();

            //Temporary solution to hide the password
            user.setPassword(null);
            return ResponseEntity.ok()
                    .header(HttpHeaders.AUTHORIZATION, jwtUtil.generateToken(user))
                    //TODO dto and mapper for userview
                    .body(user);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
