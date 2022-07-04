package com.cardgameproject.cardgame.entity;

import com.cardgameproject.cardgame.enums.rarityLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "creatures")
@NoArgsConstructor
public class Creatures extends Card {



    @Builder
    public Creatures(Long id, String name, int manaCost, String description, rarityLevel rarity) {
        super(id, name, manaCost, description, rarity);
    }
}
