package com.cardgameproject.cardgame.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "GameState")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "game_state")
public class GameStateEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private GameEntity gameEntity;
    private int gameTurn;
    private int playerHealth;
    private int mana;
    @ElementCollection
    private List<CardEntity> cardsInHand = new ArrayList<>();
    @ElementCollection
    private List<CardEntity> cardsOnTheBoard = new ArrayList<>();
    @ElementCollection
    private List<CardEntity> cardsInTheDeck = new ArrayList<>();

}
