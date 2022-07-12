package com.cardgameproject.cardgame.controller;

import com.cardgameproject.cardgame.entity.CreatureCard;
import com.cardgameproject.cardgame.entity.DeckEntity;
import com.cardgameproject.cardgame.service.CreatureCardService;
import com.cardgameproject.cardgame.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = {"https://fast-dusk-75315.herokuapp.com" , "http://localhost:3000"},
        methods = {RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
        , allowedHeaders = "*")
@RestController
public class DeckController {

    private DeckService deckService;
    private CreatureCardService creatureService;

    @Autowired
    public DeckController(DeckService deckService, CreatureCardService creatureService) {
        this.deckService = deckService;
        this.creatureService = creatureService;
    }

    @PostMapping(value = "/deck/create")
    public DeckEntity createDeck (@RequestBody Map<String, Object> payLoad){
        List<CreatureCard> cards = new ArrayList<>();
        DeckEntity deck = DeckEntity.builder()
                .cards(cards)
                .deckName((String)payLoad.get("name"))
                .build();
        deckService.createDeck(deck);
        return deck;
    }

    @GetMapping(value = "/deck")
    public List<DeckEntity> showAllDecks(){
        return deckService.getAllDecks();
    }

    @GetMapping(value ="deck/{name}")
    public List<CreatureCard> getCardsFromDeck(@PathVariable String name){
        DeckEntity deck = deckService.getDeckByName(name);
        return deck.getCards();
    }

    @DeleteMapping(value = "/deck/{id}")
    public void deleteDeckById(@PathVariable String id){
        deckService.deleteDeck(Long.valueOf(id));
    }

    @GetMapping(value ="deck/add-card/{name}")
    public DeckEntity getDeckEntity(@PathVariable String name){
         return deckService.getDeckByName(name);
    }

    @PostMapping(value = "/deck/add-card")
    public void addCardToDeck(@RequestBody Map<String, Object> payLoad){
        deckService.addCardToDeck((String)payLoad.get("name"), Long.valueOf((String)payLoad.get("id")));
    }

}
