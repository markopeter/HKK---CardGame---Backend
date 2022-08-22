package com.cardgameproject.cardgame.repository;

import com.cardgameproject.cardgame.entity.CardEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreatureCardRepository extends PagingAndSortingRepository<CardEntity, Long> {

    CardEntity findCreatureCardByName(String name);
    List<CardEntity> findAllByManaCost(int manaCost);
    List<CardEntity> findAllByName(String name);
    List<CardEntity> findAllBybaseHealth(int baseHealth);
    List<CardEntity> findAllBybaseAttack(int baseAttack);
    @Query("SELECT c FROM CardEntity c WHERE name = :name AND manaCost = :manaCost")
    List<CardEntity> findCreatureCardByNameAndManaCost(@Param("name") String name
            , @Param ("manaCost") int manaCost);

}
