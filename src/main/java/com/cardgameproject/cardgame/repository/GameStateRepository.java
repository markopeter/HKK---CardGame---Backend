package com.cardgameproject.cardgame.repository;

import com.cardgameproject.cardgame.entity.GameStateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameStateRepository extends JpaRepository<GameStateEntity, Long> {
}
