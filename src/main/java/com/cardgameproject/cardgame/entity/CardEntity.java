package com.cardgameproject.cardgame.entity;

import com.cardgameproject.cardgame.enums.raceType;
import com.cardgameproject.cardgame.enums.rarityLevel;
import com.cardgameproject.cardgame.enums.monsterStateType;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "cards")
public class CardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( nullable = false, unique = true)
    private Long id;
    @Column(
            name = "state",
            nullable = false)
    private monsterStateType state;
    @Column(
            name="manaCost",
            nullable = false
    )
    private int manaCost;
    @Column(
            name="name",
            nullable = false
    )
    @NaturalId
    private String name;
    private raceType race;
    private rarityLevel rarity;
    private int baseAttack;
    private int baseHealth;
    private boolean canUseWeapon;
    private String description;
    private String imageUrl;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.MERGE
            },
            mappedBy = "cards")

    private List<DeckEntity> decks = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardEntity card = (CardEntity) o;
        return Objects.equals(name, card.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
