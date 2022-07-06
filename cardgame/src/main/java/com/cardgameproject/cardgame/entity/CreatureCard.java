package com.cardgameproject.cardgame.entity;

import com.cardgameproject.cardgame.enums.raceType;
import com.cardgameproject.cardgame.enums.rarityLevel;
import com.cardgameproject.cardgame.enums.stateType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "CreatureCard")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "creaturecard")
public class CreatureCard {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(
            name = "state",
            nullable = false)
    private stateType state;
    private int manaCost;
    private String name;
    private raceType race;
    private rarityLevel rarity;
    private int baseAttack;
    private int baseHealth;
    private boolean canUseWeapon;
    private String description;


}
