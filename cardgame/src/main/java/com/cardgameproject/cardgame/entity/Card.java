package com.cardgameproject.cardgame.entity;

import com.cardgameproject.cardgame.enums.rarityLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="discriminatorColumn")
@Table(name="AbstractCard")
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int manaCost;
    private String description;
    private rarityLevel rarity;

}
