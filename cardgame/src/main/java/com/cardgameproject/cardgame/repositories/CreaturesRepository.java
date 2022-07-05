package com.cardgameproject.cardgame.repositories;

import com.cardgameproject.cardgame.entity.Creatures;
import com.cardgameproject.cardgame.enums.stateType;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CreaturesRepository extends CardRepository {

    Creatures findByName(String name);
    List<Creatures> findAllBybaseAttack(int attack);
    List<Creatures> findAllBybaseHealth(int health);
    List<Creatures> findAllBystate(stateType state);
}
