package com.cardgameproject.cardgame.repository;

import com.cardgameproject.cardgame.entity.OriginalCard;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OriginalCardRepository extends PagingAndSortingRepository<OriginalCard, Long> {
}
