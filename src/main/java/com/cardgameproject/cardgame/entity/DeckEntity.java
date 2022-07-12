package com.cardgameproject.cardgame.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Deck")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "deck")
public class DeckEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    @JoinTable(name="deck_creaturecard",
            joinColumns=
            @JoinColumn(name="deck_id", referencedColumnName="id"),
            inverseJoinColumns=
            @JoinColumn(name="creaturecard_id", referencedColumnName="id")
    )
    @JsonIgnore
    private List<CreatureCard> cards = new ArrayList<>();
    private String deckName;
}
