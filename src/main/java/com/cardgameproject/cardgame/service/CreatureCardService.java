package com.cardgameproject.cardgame.service;
import com.cardgameproject.cardgame.entity.CreatureCard;
import com.cardgameproject.cardgame.repositories.CreatureCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreatureCardService {

    private CreatureCardRepository creatureRepository;
    @Autowired
    public CreatureCardService(CreatureCardRepository creatureRepository) {
        this.creatureRepository = creatureRepository;
    }

    public List<CreatureCard> getAllCreatures(){
        return creatureRepository.findAll();
    }
    public void addCreatureCard(CreatureCard card){
        creatureRepository.save(card);
    }
    public CreatureCard findCreatureCardByName(String name){
        return creatureRepository.findCreatureCardByName(name);
    }

}
