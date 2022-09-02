package com.cardgameproject.cardgame.service;

import com.cardgameproject.cardgame.entity.CardEntity;
import com.cardgameproject.cardgame.entity.GameStateEntity;
import com.cardgameproject.cardgame.repository.GameStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameStateService {

    private GameStateRepository gameStateRepository;

    @Autowired
    public GameStateService(GameStateRepository gameStateRepository) {
        this.gameStateRepository = gameStateRepository;
    }

    public GameStateEntity getGameStateById(Long id){
        return gameStateRepository.findById(id).orElse(null);
    }

    public List<CardEntity> getCardsFromBoard (GameStateEntity gameState){
        return gameState.getCardsOnTheBoard();
    }

}
