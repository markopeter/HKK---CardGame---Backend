package com.cardgameproject.cardgame.service;
import com.cardgameproject.cardgame.entity.CreatureCard;
import com.cardgameproject.cardgame.enums.stateType;
import com.cardgameproject.cardgame.repositories.CreaturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreaturesCardService implements CreaturesService {

    private CreaturesRepository creatureRepository;
    @Autowired
    public CreaturesCardService(CreaturesRepository creatureRepository) {
        this.creatureRepository = creatureRepository;
    }

    @Override
    public CreatureCard findByName(String name) {
        return creatureRepository.findByName(name);
    }

    @Override
    public List<CreatureCard> findAllBybaseAttack(int attack) {
       return creatureRepository.findAllBybaseAttack(attack);
    }

    @Override
    public List<CreatureCard> findAllBybaseHealth(int health) {
        return creatureRepository.findAllBybaseHealth(health);
    }

    @Override
    public List<CreatureCard> findAllBystateType(stateType state) {
        return creatureRepository.findAllBystate(state);
    }

    public List<CreatureCard> getAllCreatures (){
       return creatureRepository.findAll()
               .stream()
               .filter(cre -> cre instanceof CreatureCard)
               .map (cre -> (CreatureCard) cre)
               .collect(Collectors.toList());
    }
}
