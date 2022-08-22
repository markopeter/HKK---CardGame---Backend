package com.cardgameproject.cardgame.controller;

import com.cardgameproject.cardgame.dto.CardDto;
import com.cardgameproject.cardgame.entity.CardEntity;
import com.cardgameproject.cardgame.repository.CreatureCardRepository;
import com.cardgameproject.cardgame.service.CreatureCardService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"https://fast-dusk-75315.herokuapp.com" , "http://localhost:3000"},
        methods = {RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
        , allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class CardController {

    private CreatureCardService creatureService;
    private CreatureCardRepository creatureRepository;


    @Autowired
    public CardController(CreatureCardService creatureService, CreatureCardRepository creatureRepository, ModelMapper modelMapper) {
        this.creatureService = creatureService;
        this.creatureRepository = creatureRepository;
    }


    @GetMapping("/creature/{name}")
    public CardDto getCreatureCardByName(@PathVariable String name)
    {
         return creatureService.findCreatureCardByName(name);
    }

    @GetMapping("/creatures")
    public List<CardDto> getAllCreatures (){
        return creatureService.getAllCreatures();
    }

    @GetMapping("/card/page")
    public Page<CardEntity> findAll(@RequestParam int page, @RequestParam int size){
        PageRequest pageRequest = PageRequest.of(page,size);
        return creatureRepository.findAll(pageRequest);
    }

    @GetMapping("/creature/{name}/{manaCost}")
    public List<CardDto> getAllCardByNameAndManaCost
            (@PathVariable String manaCost, @PathVariable String name){
        return creatureService.findCardsByNameAndManaCost(
                name, Integer.parseInt(manaCost));
    }

    @GetMapping("/creature/detail/{detail}/value/{value}")
    public List<CardDto> getAllCardsByDetail(@PathVariable String detail, @PathVariable String value){
        return creatureService.findCardsByDetail(detail,value);
    }
}
