package com.cardgameproject.cardgame.repositories;

import com.cardgameproject.cardgame.entity.CreatureCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreatureCardRepository extends JpaRepository<CreatureCard, Long> {
}
