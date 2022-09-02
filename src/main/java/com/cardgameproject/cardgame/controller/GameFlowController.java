package com.cardgameproject.cardgame.controller;


import com.cardgameproject.cardgame.entity.*;
import com.cardgameproject.cardgame.service.DeckService;
import com.cardgameproject.cardgame.service.GameService;
import com.cardgameproject.cardgame.service.GameStateService;
import com.cardgameproject.cardgame.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin(origins = {"https://fast-dusk-75315.herokuapp.com" , "http://localhost:3000"},
        methods = {RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
        , allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class GameFlowController {

    private GameService gameService;
    private GameStateService gameStateService;
    private DeckService deckService;
    private UserDetailServiceImpl userService;

    @Autowired
    public GameFlowController(GameService gameService, GameStateService gameStateService, DeckService deckService, UserDetailServiceImpl userService) {
        this.gameService = gameService;
        this.gameStateService = gameStateService;
        this.deckService = deckService;
        this.userService = userService;
    }

    @GetMapping(value = "/get_game/{id}")
    public GameEntity getGame(@PathVariable String id){
        return gameService.getGameById(Long.valueOf(id));
    }
    @GetMapping(value = "/get_game/deck/{id}")
    public DeckEntity getDeck(@PathVariable String id){
        GameEntity game = gameService.getGameById(Long.valueOf(id));
        return game.getDeck();
    }

    @GetMapping(value = "/get_game/game_state/cards_on_board/{id}")
    public List<CardEntity> getCardsOnTheBoard(@PathVariable String id){

        GameStateEntity gameState = gameStateService.getGameStateById(Long.valueOf(id));
        System.out.println(gameState.getMana());
         return gameStateService.getCardsFromBoard(gameState);
    }

    @GetMapping(value = "/mulligan/{id}")
    public Set<CardEntity> getTheMulligan(@PathVariable String id){
        return deckService.getMulligan(Long.valueOf(id));
    }

    @GetMapping(value = "/start_game/{user_id}/{deck_id}")
    public GameEntity startGame(@PathVariable String deck_id, @PathVariable String user_id){
        UserEntity user = userService.getUserById(Long.valueOf(user_id));
        DeckEntity deck = deckService.getDeckByUserIdAndDeckId(Long.valueOf(user_id),
                Long.valueOf(deck_id));
        return gameService.createAGame(user, deck);
    }
}
