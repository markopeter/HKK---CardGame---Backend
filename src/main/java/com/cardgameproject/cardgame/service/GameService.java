package com.cardgameproject.cardgame.service;

import com.cardgameproject.cardgame.entity.DeckEntity;
import com.cardgameproject.cardgame.entity.GameEntity;
import com.cardgameproject.cardgame.entity.UserEntity;
import com.cardgameproject.cardgame.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class GameService {

    private GameRepository gameRepository;
    private UserDetailServiceImpl userService;
    private DeckService deckService;

    @Autowired
    public GameService(GameRepository gameRepository, UserDetailServiceImpl userService, DeckService deckService) {
        this.gameRepository = gameRepository;
        this.userService = userService;
        this.deckService = deckService;
    }

    public void saveGame(GameEntity game){
        gameRepository.save(game);
    }
    public GameEntity getGameById(Long id){
        return gameRepository.findById(id).orElse(null);
    }

    public GameEntity createAGame(UserEntity user, DeckEntity deck){
        GameEntity game = GameEntity.builder()
                .date(LocalDate.now())
                .gameStates(new ArrayList<>())
                .user(user)
                .deck(deck)
                .build();
        deck.addGame(game);
        //TODO
        // find out why the saveDeck method persist the game entity as well
//        deckService.saveDeck(deck);
        gameRepository.save(game);
        user.addGame(game);
        userService.saveUser(user);
        return game;
    }
}
