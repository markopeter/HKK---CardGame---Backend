package com.cardgameproject.cardgame.service;
import com.cardgameproject.cardgame.entity.CardEntity;
import com.cardgameproject.cardgame.repository.CreatureCardRepository;
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

    public List<CardEntity> getAllCreatures(){
        return (List<CardEntity>) creatureRepository.findAll();
    }
    public void addCreatureCard(CardEntity card){
        creatureRepository.save(card);
    }
    public CardEntity findCreatureCardByName(String name){
        return creatureRepository.findCreatureCardByName(name);
    }
    public List<CardEntity> findCardsByNameAndManaCost (String name, int manaCost){
        return creatureRepository.findCreatureCardByNameAndManaCost(name, manaCost);
    }

    public List<CardEntity> findCardsByDetail(String detail, String value){
        switch(detail){
            case "name":
                return creatureRepository.findAllByName(value);
            case "manaCost":
                return creatureRepository.findAllByManaCost(Integer.parseInt(value));
            case "baseAttack":
                return creatureRepository.findAllBybaseAttack(Integer.parseInt(value));
            case "baseHealth":
                return creatureRepository.findAllBybaseHealth(Integer.parseInt(value));
            default:
                System.out.println("No card found !");
        }
        return null;
    }
}
