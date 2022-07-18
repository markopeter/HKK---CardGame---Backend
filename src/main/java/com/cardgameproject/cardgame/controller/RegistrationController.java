package com.cardgameproject.cardgame.controller;

import com.cardgameproject.cardgame.entity.Users;
import com.cardgameproject.cardgame.event.RegistrationCompleteEvent;
import com.cardgameproject.cardgame.model.UserModel;
import com.cardgameproject.cardgame.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RegistrationController {

    private UserService userService;
    private ApplicationEventPublisher publisher;

    @Autowired
    public RegistrationController(UserService userService, ApplicationEventPublisher publisher) {
        this.userService = userService;
        this.publisher = publisher;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel, final HttpServletRequest request){
        Users users = userService.registerUser(userModel);
        publisher.publishEvent(new RegistrationCompleteEvent(
                users, applicationUrl(request)
        ));
        return "Succes";
    }

    private String applicationUrl(HttpServletRequest request) {

        return "http://" + request.getServerName() + ":" + request.getServerPort()
                + request.getContextPath();
    }


}
