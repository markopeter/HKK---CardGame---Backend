package com.cardgameproject.cardgame.service;

import com.cardgameproject.cardgame.entity.Creatures;
import org.springframework.stereotype.Service;

@Service
public interface CreaturesService {

    Creatures findByName(String name);
}
