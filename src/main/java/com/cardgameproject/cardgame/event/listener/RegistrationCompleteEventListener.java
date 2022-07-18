package com.cardgameproject.cardgame.event.listener;

import com.cardgameproject.cardgame.entity.Users;
import com.cardgameproject.cardgame.event.RegistrationCompleteEvent;
import com.cardgameproject.cardgame.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // Create the Verification token to the user
        Users users = event.getUsers();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(users, token);
        // Send email to the user
        String url = event.getApplicationUrl() + "verifyRegistration?token=" + token;

        // TODO send the email

        log.info("Click the link to verify your account : {}" + url);
    }
}
