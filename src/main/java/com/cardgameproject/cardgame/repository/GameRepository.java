package com.cardgameproject.cardgame.repository;

import com.cardgameproject.cardgame.entity.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<GameEntity, Long> {
}
