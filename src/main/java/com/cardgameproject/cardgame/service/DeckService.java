package com.cardgameproject.cardgame.service;

import com.cardgameproject.cardgame.entity.CardEntity;
import com.cardgameproject.cardgame.entity.DeckEntity;
import com.cardgameproject.cardgame.entity.GameEntity;
import com.cardgameproject.cardgame.entity.UserEntity;
import com.cardgameproject.cardgame.repository.CreatureCardRepository;
import com.cardgameproject.cardgame.repository.DeckRepository;
import com.cardgameproject.cardgame.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DeckService {

    private DeckRepository deckRepository;
    private CreatureCardRepository creatureCardRepository;
    private GameRepository gameEntityRepository;


    @Autowired
    public DeckService(DeckRepository deckRepository, CreatureCardRepository creatureCardRepository, GameRepository gameEntityRepository) {
        this.deckRepository = deckRepository;
        this.creatureCardRepository = creatureCardRepository;
        this.gameEntityRepository = gameEntityRepository;
    }

    public DeckEntity createDeck(String name, UserEntity user){
        List<CardEntity> cards = new ArrayList<>();
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
        CardEntity cardToAdd = creatureCardRepository.findById(cardId).get();
        List<CardEntity> cards = selectedDeck.getCards();
        cards.add(cardToAdd);
        deckRepository.save(selectedDeck);
    }

    public Set<CardEntity> getMulligan (Long id){
        Random rand = new Random();
        GameEntity game = gameEntityRepository.findById(id).orElse(null);
        assert game != null;
        DeckEntity deck = game.getDeck();
        Set<CardEntity> mulligan = new HashSet<>();
        int handSize = 5;

        while(mulligan.size() != handSize){
            mulligan.add(deck.getCards().get(rand.nextInt(deck.getCards().size())));
        }
        return mulligan;
    }

    public void saveDeck(DeckEntity deck){
        deckRepository.save(deck);
    }

    public DeckEntity getDeckByUserIdAndDeckId (Long user_id, Long deck_id){
        List<DeckEntity> decks = deckRepository.findDeckEntitiesByUserId(user_id);
        DeckEntity deckToAdd = null;
        for (DeckEntity deck : decks) {
            if(Objects.equals(deck.getId(), deck_id)){
                deckToAdd = deck;
            }
        }
        return deckToAdd;
    }

}
