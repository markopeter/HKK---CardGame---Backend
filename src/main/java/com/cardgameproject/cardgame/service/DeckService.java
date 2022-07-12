package com.cardgameproject.cardgame.service;

import com.cardgameproject.cardgame.entity.DeckEntity;
import com.cardgameproject.cardgame.repositories.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeckService {

    private DeckRepository deckRepository;

    @Autowired
    public DeckService(DeckRepository deckRepository) {
        this.deckRepository = deckRepository;
    }

    public void createDeck(DeckEntity deck){
        deckRepository.save(deck);
    }

    public List<DeckEntity> getAllDecks(){
        return deckRepository.findAll();
    }

    public DeckEntity getDeckByName(String name){
        return deckRepository.findDeckEntityByDeckName(name);
    }
}
