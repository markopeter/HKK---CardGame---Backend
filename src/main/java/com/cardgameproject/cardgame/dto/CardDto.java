package com.cardgameproject.cardgame.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {

    private Long id;
    private String name;
    private int baseAttack;
    private int baseHealth;
    private int manaCost;
    private String imageUrl;

}
