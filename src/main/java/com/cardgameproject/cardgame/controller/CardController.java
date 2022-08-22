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
import java.util.stream.Collectors;

@CrossOrigin(origins = {"https://fast-dusk-75315.herokuapp.com" , "http://localhost:3000"},
        methods = {RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
        , allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class CardController {

    private CreatureCardService creatureService;
    private CreatureCardRepository creatureRepository;
    private ModelMapper modelMapper;

    @Autowired
    public CardController(CreatureCardService creatureService, CreatureCardRepository creatureRepository, ModelMapper modelMapper) {
        this.creatureService = creatureService;
        this.creatureRepository = creatureRepository;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/creature/{name}")
    public CardDto getCreatureCardByName(@PathVariable String name)
    {
         return convertToDto(creatureService.findCreatureCardByName(name));
    }

    @GetMapping("/creatures")
    public List<CardDto> getAllCreatures (){
        List<CardEntity> allCards = creatureService.getAllCreatures();
        return allCards.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/card/page")
    public Page<CardEntity> findAll(@RequestParam int page, @RequestParam int size){
        PageRequest pageRequest = PageRequest.of(page,size);
        return creatureRepository.findAll(pageRequest);
    }

    @GetMapping("/creature/{name}/{manaCost}")
    public List<CardDto> getAllCardByNameAndManaCost
            (@PathVariable String manaCost, @PathVariable String name){
        List<CardEntity> searchResult = creatureService.findCardsByNameAndManaCost(
                name, Integer.parseInt(manaCost));
        return searchResult.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/creature/detail/{detail}/value/{value}")
    public List<CardDto> getAllCardsByDetail(@PathVariable String detail, @PathVariable String value){
        List<CardEntity> searchResult = creatureService.findCardsByDetail(detail,value);
        return searchResult.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private CardDto convertToDto(CardEntity card) {
        return modelMapper.map(card, CardDto.class);
    }

}
