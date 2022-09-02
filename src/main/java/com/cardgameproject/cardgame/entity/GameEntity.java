package com.cardgameproject.cardgame.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "game")
public class GameEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy ="gameEntity", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<GameStateEntity> gameStates = new ArrayList<>();
    @Column
    private LocalDate date;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonIgnore
    private UserEntity user;
    @ManyToOne(optional = false)
    @JsonIgnore
    private DeckEntity deck;

    public void addGameState(GameStateEntity state) {
        gameStates.add(state);
        state.setGameEntity(this);
    }

    public void removeGameState(GameStateEntity state) {
        gameStates.remove(state);
        state.setGameEntity(null);
    }

}
