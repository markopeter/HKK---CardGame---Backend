package com.cardgameproject.cardgame.controller;

import com.cardgameproject.cardgame.service.CreaturesCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = {"http://localhost:3000"},
        methods = {RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
        , allowedHeaders = "*")
@RestController
public class CardController {

    private CreaturesCardService creatureService;

    @Autowired
    public CardController(CreaturesCardService creatureService) {
        this.creatureService = creatureService;
    }
}
