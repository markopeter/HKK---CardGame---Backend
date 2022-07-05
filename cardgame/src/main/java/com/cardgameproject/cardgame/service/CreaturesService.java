package com.cardgameproject.cardgame.service;

import com.cardgameproject.cardgame.entity.Creatures;
import com.cardgameproject.cardgame.enums.stateType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CreaturesService {

    Creatures findByName(String name);
    List<Creatures> findAllBybaseAttack(int attack);
    List<Creatures> findAllBybaseHealth(int health);
    List<Creatures> findAllBystateType(stateType state);
}
