package com.cardgameproject.cardgame.service;
import com.cardgameproject.cardgame.entity.Creatures;
import com.cardgameproject.cardgame.enums.stateType;
import com.cardgameproject.cardgame.repositories.CreaturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreaturesCardService implements CreaturesService {

    private CreaturesRepository creatureRepository;
    @Autowired
    public CreaturesCardService(CreaturesRepository creatureRepository) {
        this.creatureRepository = creatureRepository;
    }

    @Override
    public Creatures findByName(String name) {
        return creatureRepository.findByName(name);
    }

    @Override
    public List<Creatures> findAllBybaseAttack(int attack) {
       return creatureRepository.findAllBybaseAttack(attack);
    }

    @Override
    public List<Creatures> findAllBybaseHealth(int health) {
        return creatureRepository.findAllBybaseHealth(health);
    }

    @Override
    public List<Creatures> findAllBystateType(stateType state) {
        return creatureRepository.findAllBystate(state);
    }
}
