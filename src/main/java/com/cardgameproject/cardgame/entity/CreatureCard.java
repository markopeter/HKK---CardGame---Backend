package com.cardgameproject.cardgame.entity;

import com.cardgameproject.cardgame.enums.raceType;
import com.cardgameproject.cardgame.enums.rarityLevel;
import com.cardgameproject.cardgame.enums.stateType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @Column(
            name="manaCost",
            nullable = false
    )
    private int manaCost;
    @Column(
            name="name",
            nullable = false
    )
    private String name;
    private raceType race;
    private rarityLevel rarity;
    private int baseAttack;
    private int baseHealth;
    private boolean canUseWeapon;
    private String description;
    private String imageUrl;
    @ManyToMany(mappedBy="cards")
    @JsonIgnore
    private List<DeckEntity> decks = new ArrayList<>();


}
