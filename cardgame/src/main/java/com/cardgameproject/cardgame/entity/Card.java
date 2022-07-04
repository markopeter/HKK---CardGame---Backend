package com.cardgameproject.cardgame.entity;

import com.cardgameproject.cardgame.enums.rarityLevel;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int manaCost;
    private String description;
    private rarityLevel rarity;

}
