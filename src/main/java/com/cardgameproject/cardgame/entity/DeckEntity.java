package com.cardgameproject.cardgame.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table (name ="decks")
public class DeckEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.MERGE
            })
    @JoinTable(name = "deck_cards",
            joinColumns = { @JoinColumn(name = "DeckEntity_id")},
            inverseJoinColumns = { @JoinColumn(name = "Card_id")})
    @JsonIgnore
    private List<CardEntity> cards = new ArrayList<>();
    private String deckName;
    @ManyToOne(optional = false)
    private UserEntity user;

    @OneToMany(mappedBy = "deck", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<GameEntity> games = new ArrayList<>();

    public void addGame(GameEntity game){
        games.add(game);
        game.setDeck(this);
    }

    public void removeGame(GameEntity game) {
        games.remove(game);
        game.setDeck(null);
    }

}
