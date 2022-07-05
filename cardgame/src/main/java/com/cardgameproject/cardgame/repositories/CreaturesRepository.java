package com.cardgameproject.cardgame.repositories;

import com.cardgameproject.cardgame.entity.Creatures;
import org.springframework.stereotype.Repository;


@Repository
public interface CreaturesRepository extends CardRepository {

    Creatures findByName(String name);

}
