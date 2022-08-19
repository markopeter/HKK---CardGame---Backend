package com.cardgameproject.cardgame.controller;

import com.cardgameproject.cardgame.entity.Card;
import com.cardgameproject.cardgame.entity.DeckEntity;
import com.cardgameproject.cardgame.entity.UserEntity;
import com.cardgameproject.cardgame.service.CreatureCardService;
import com.cardgameproject.cardgame.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = {"https://fast-dusk-75315.herokuapp.com" , "http://localhost:3000"},
        methods = {RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
        , allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class DeckController {

    private DeckService deckService;
    private CreatureCardService creatureService;

    @Autowired
    public DeckController(DeckService deckService, CreatureCardService creatureService) {
        this.deckService = deckService;
        this.creatureService = creatureService;
    }

    @PostMapping(value = "/deck/create")
    public ResponseEntity<?> createDeck (@RequestBody Map<String, Object> payLoad,
                                         @AuthenticationPrincipal UserEntity user){
        DeckEntity deck = deckService.createDeck((String)payLoad.get("name"), user);
        return ResponseEntity.ok(deck);
    }

    @GetMapping(value = "/deck")
    public List<DeckEntity> showAllDecks(){
        return deckService.getAllDecks();
    }

    @GetMapping(value ="/deck/{name}")
    public List<Card> getCardsFromDeck(@PathVariable String name){
        DeckEntity deck = deckService.getDeckByName(name);
        return deck.getCards();
    }

    @DeleteMapping(value = "/deck/{id}")
    public void deleteDeckById(@PathVariable String id){
        deckService.deleteDeck(Long.valueOf(id));
    }

    @GetMapping(value ="/deck/add-card/{name}")
    public DeckEntity getDeckEntity(@PathVariable String name){
         return deckService.getDeckByName(name);
    }

    @PostMapping(value = "/deck/add-card")
    public void addCardToDeck(@RequestBody Map<String, Object> payLoad){
        deckService.addCardToDeck((String)payLoad.get("name"), Long.valueOf((String)payLoad.get("id")));
    }

}
