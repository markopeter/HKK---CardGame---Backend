package com.cardgameproject.cardgame.entity;

import com.cardgameproject.cardgame.enums.rarityLevel;

public class Creatures extends Card {
    public Creatures(Long id, String name, int manaCost, String description, rarityLevel rarity) {
        super(id, name, manaCost, description, rarity);
    }
}
