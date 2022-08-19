package com.cardgameproject.cardgame.service;

import com.cardgameproject.cardgame.entity.Card;
import com.cardgameproject.cardgame.entity.DeckEntity;
import com.cardgameproject.cardgame.entity.UserEntity;
import com.cardgameproject.cardgame.repository.CreatureCardRepository;
import com.cardgameproject.cardgame.repository.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public DeckEntity createDeck(String name, UserEntity user){
        List<Card> cards = new ArrayList<>();
        DeckEntity deck = DeckEntity.builder()
                .cards(cards)
                .deckName(name)
                .user(user)
                .build();
        return deckRepository.save(deck);

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
        Card cardToAdd = creatureCardRepository.findById(cardId).get();
        List<Card> cards = selectedDeck.getCards();
        cards.add(cardToAdd);
        deckRepository.save(selectedDeck);
    }
}
