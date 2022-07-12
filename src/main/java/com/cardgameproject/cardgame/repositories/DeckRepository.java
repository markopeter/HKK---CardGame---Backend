package com.cardgameproject.cardgame.repositories;

import com.cardgameproject.cardgame.entity.DeckEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckRepository extends JpaRepository<DeckEntity, Long> {
    DeckEntity findDeckEntityByDeckName(String name);
}
