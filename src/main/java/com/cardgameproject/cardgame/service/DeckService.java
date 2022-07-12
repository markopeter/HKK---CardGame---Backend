package com.cardgameproject.cardgame.service;

import com.cardgameproject.cardgame.entity.CreatureCard;
import com.cardgameproject.cardgame.entity.DeckEntity;
import com.cardgameproject.cardgame.repositories.CreatureCardRepository;
import com.cardgameproject.cardgame.repositories.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeckService {

    private DeckRepository deckRepository;
    private CreatureCardRepository creatureCardRepository;

    @Autowired
    public DeckService(DeckRepository deckRepository, CreatureCardRepository creatureCardRepository) {
        this.deckRepository = deckRepository;
        this.creatureCardRepository = creatureCardRepository;
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

    public void deleteDeck(Long id){
        deckRepository.deleteById(id);
    }

    public void addCardToDeck(String name, Long cardId){
        DeckEntity selectedDeck = deckRepository.findDeckEntityByDeckName(name);
        CreatureCard cardToAdd = creatureCardRepository.findById(cardId).get();
        List<CreatureCard> cards = selectedDeck.getCards();
        cards.add(cardToAdd);
    }
}
