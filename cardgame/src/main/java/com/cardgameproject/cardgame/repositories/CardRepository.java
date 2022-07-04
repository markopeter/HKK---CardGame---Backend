package com.cardgameproject.cardgame.repositories;

import com.cardgameproject.cardgame.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
