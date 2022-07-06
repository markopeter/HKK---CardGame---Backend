package com.cardgameproject.cardgame.card_creator;

import com.cardgameproject.cardgame.entity.CreatureCard;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.cardgameproject.cardgame.enums.raceType.MONSTER;
import static com.cardgameproject.cardgame.enums.rarityLevel.COMMON;
import static com.cardgameproject.cardgame.enums.stateType.ACTIVE;

@Component
public class CardCreator {

    public static List<CreatureCard> createStarterCard(){
        List<CreatureCard> cards = new ArrayList<>();

        CreatureCard test1 =  CreatureCard.builder()
                .baseAttack(10)
                .baseHealth(10)
                .canUseWeapon(false)
                .description("Test")
                .manaCost(2)
                .name("Boogeyman")
                .race(MONSTER)
                .rarity(COMMON)
                .state(ACTIVE)
                .build();
        CreatureCard test2 =  CreatureCard.builder()
                .baseAttack(12)
                .baseHealth(10)
                .canUseWeapon(false)
                .description("Test")
                .manaCost(2)
                .name("SpookySkeleton")
                .race(MONSTER)
                .rarity(COMMON)
                .state(ACTIVE)
                .build();
        cards.add(test1);
        cards.add(test2);

        return cards;
    }

}
