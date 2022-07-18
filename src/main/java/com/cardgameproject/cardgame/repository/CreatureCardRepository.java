package com.cardgameproject.cardgame.repository;

import com.cardgameproject.cardgame.entity.Card;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreatureCardRepository extends PagingAndSortingRepository<Card, Long> {

    Card findCreatureCardByName(String name);
    List<Card> findAllByManaCost(int manaCost);
    List<Card> findAllByName(String name);
    List<Card> findAllBybaseHealth(int baseHealth);
    List<Card> findAllBybaseAttack(int baseAttack);
    @Query("SELECT c FROM Card c WHERE name = :name AND manaCost = :manaCost")
    List<Card> findCreatureCardByNameAndManaCost(@Param("name") String name
            , @Param ("manaCost") int manaCost);

}
