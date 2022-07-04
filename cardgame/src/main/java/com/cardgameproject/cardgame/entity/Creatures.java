package com.cardgameproject.cardgame.entity;

import com.cardgameproject.cardgame.enums.raceType;
import com.cardgameproject.cardgame.enums.rarityLevel;
import com.cardgameproject.cardgame.enums.stateType;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "creatures")
@NoArgsConstructor
public class Creatures extends Card {

    private stateType state;
    private raceType race;
    private int baseAttack;
    private int baseHealth;
    private boolean canUseWeapon;


    @Builder
    public Creatures(Long id, String name, int manaCost, String description, rarityLevel rarity, raceType race, int baseAttack, int baseHealth, boolean canUseWeapon) {
        super(id, name, manaCost, description, rarity);
        this.race = race;
        this.baseAttack = baseAttack;
        this.baseHealth = baseHealth;
        this.canUseWeapon = canUseWeapon;
    }
}
