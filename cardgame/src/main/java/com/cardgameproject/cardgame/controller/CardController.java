package com.cardgameproject.cardgame.controller;

import com.cardgameproject.cardgame.entity.Card;
import com.cardgameproject.cardgame.entity.Creatures;
import com.cardgameproject.cardgame.service.CreaturesCardService;
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

    private CreaturesCardService creatureService;

    @Autowired
    public CardController(CreaturesCardService creatureService) {
        this.creatureService = creatureService;
    }

    @GetMapping("/creatures")
    public List<Creatures> getAllCreatures (){
        return creatureService.getAllCreatures();
    }

}
