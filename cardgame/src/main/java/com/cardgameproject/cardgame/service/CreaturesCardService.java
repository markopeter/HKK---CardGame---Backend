package com.cardgameproject.cardgame.service;
import com.cardgameproject.cardgame.entity.Creatures;
import com.cardgameproject.cardgame.repositories.CreaturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
