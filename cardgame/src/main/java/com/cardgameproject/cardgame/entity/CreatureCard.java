package com.cardgameproject.cardgame.entity;

import com.cardgameproject.cardgame.enums.raceType;
import com.cardgameproject.cardgame.enums.stateType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity(name = "creature_card")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CreatureCard {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "state",
            nullable = false)
    private stateType state;
    private raceType race;
    private int baseAttack;
    private int baseHealth;
    private boolean canUseWeapon;


}