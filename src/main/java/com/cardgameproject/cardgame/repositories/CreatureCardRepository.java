package com.cardgameproject.cardgame.repositories;

import com.cardgameproject.cardgame.entity.CreatureCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreatureCardRepository extends PagingAndSortingRepository<CreatureCard, Long> {

    CreatureCard findCreatureCardByName(String name);

}
