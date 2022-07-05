package com.cardgameproject.cardgame.repositories;

import com.cardgameproject.cardgame.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

}
