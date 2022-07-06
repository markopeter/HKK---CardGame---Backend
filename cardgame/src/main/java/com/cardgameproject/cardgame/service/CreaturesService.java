package com.cardgameproject.cardgame.service;

import com.cardgameproject.cardgame.entity.CreatureCard;
import com.cardgameproject.cardgame.enums.stateType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CreaturesService {

    CreatureCard findByName(String name);
    List<CreatureCard> findAllBybaseAttack(int attack);
    List<CreatureCard> findAllBybaseHealth(int health);
    List<CreatureCard> findAllBystateType(stateType state);
}
