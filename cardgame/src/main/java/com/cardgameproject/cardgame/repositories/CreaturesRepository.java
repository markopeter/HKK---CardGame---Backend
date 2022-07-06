package com.cardgameproject.cardgame.repositories;

import com.cardgameproject.cardgame.entity.CreatureCard;
import com.cardgameproject.cardgame.enums.stateType;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CreaturesRepository extends CardRepository {

    CreatureCard findByName(String name);
    List<CreatureCard> findAllBybaseAttack(int attack);
    List<CreatureCard> findAllBybaseHealth(int health);
    List<CreatureCard> findAllBystate(stateType state);
}
