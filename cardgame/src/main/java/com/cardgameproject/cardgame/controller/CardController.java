package com.cardgameproject.cardgame.controller;

import com.cardgameproject.cardgame.entity.CreatureCard;
import com.cardgameproject.cardgame.service.CreatureCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"},
        methods = {RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
        , allowedHeaders = "*")
@RestController
public class CardController {

    private CreatureCardService creatureService;

    @Autowired
    public CardController(CreatureCardService creatureService) {
        this.creatureService = creatureService;
    }

    @GetMapping("/creatures")
    public List<CreatureCard> getAllCreatures (){
        return creatureService.getAllCreatures();
    }

}
