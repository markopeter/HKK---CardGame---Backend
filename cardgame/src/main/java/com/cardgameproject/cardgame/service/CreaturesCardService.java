package com.cardgameproject.cardgame.service;
import com.cardgameproject.cardgame.entity.CreatureCard;
import com.cardgameproject.cardgame.enums.stateType;
import com.cardgameproject.cardgame.repositories.CreatureCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreaturesCardService  {

    private CreatureCardRepository creatureRepository;
    @Autowired
    public CreaturesCardService(CreatureCardRepository creatureRepository) {
        this.creatureRepository = creatureRepository;
    }


}
