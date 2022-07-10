package com.cardgameproject.cardgame.controller;

import com.cardgameproject.cardgame.entity.CreatureCard;
import com.cardgameproject.cardgame.repositories.CreatureCardRepository;
import com.cardgameproject.cardgame.service.CreatureCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"https://fast-dusk-75315.herokuapp.com" , "http://localhost:3000"},
        methods = {RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
        , allowedHeaders = "*")
@RestController
public class CardController {

    private CreatureCardService creatureService;
    private CreatureCardRepository creatureRepository;

    @Autowired
    public CardController(CreatureCardService creatureService, CreatureCardRepository creatureRepository) {
        this.creatureService = creatureService;
        this.creatureRepository = creatureRepository;
    }


    @GetMapping("/creature/{name}")
    public CreatureCard getCreatureCardByName(@PathVariable String name)
    {
        return creatureService.findCreatureCardByName(name);
    }

    @GetMapping("/creatures")
    public List<CreatureCard> getAllCreatures (){
        return creatureService.getAllCreatures();
    }

    @GetMapping("/")
    public Page<CreatureCard> findAll(@RequestParam int page, @RequestParam int size){
        PageRequest pageRequest = PageRequest.of(page,size);
        return creatureRepository.findAll(pageRequest);
    }

}
