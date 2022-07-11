package com.cardgameproject.cardgame.repositories;

import com.cardgameproject.cardgame.entity.CreatureCard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreatureCardRepository extends PagingAndSortingRepository<CreatureCard, Long> {

    CreatureCard findCreatureCardByName(String name);
    @Query("SELECT c FROM CreatureCard c WHERE name = :name AND manaCost = :manaCost")
    List<CreatureCard> findByNameAndManaCost(@Param("name") String name
            ,@Param ("manaCost") String manaCost);

}
