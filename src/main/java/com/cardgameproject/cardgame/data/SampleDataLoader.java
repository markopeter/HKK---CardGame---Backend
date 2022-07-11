package com.cardgameproject.cardgame.data;

import com.cardgameproject.cardgame.entity.CreatureCard;
import com.cardgameproject.cardgame.repositories.CreatureCardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

import static com.cardgameproject.cardgame.enums.raceType.MONSTER;
import static com.cardgameproject.cardgame.enums.rarityLevel.COMMON;
import static com.cardgameproject.cardgame.enums.stateType.PASSIVE;

@Component
public class SampleDataLoader implements CommandLineRunner {


    private final CreatureCardRepository cardRepository;

    public SampleDataLoader(CreatureCardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        int amountOfCards = 100;
        String [] randomNames = {"SpookySkeleton", "BoogeyMan", "BigBadWolf", "ScaryGhost", "TerrificTroll"};
        Random rand = new Random();
        for(int i = 0; i < amountOfCards; i++) {
            cardRepository.save(
                    CreatureCard.builder()
                            .baseAttack(rand.nextInt((10 - 1) + 1) + 1)
                            .baseHealth(rand.nextInt((10 - 1) + 1) + 1)
                            .canUseWeapon(true)
                            .description("This the test card number : " + i)
                            .manaCost(rand.nextInt((10 - 1) + 1) + 1)
                            //TODO
                            //Get rid of magic numbers, extract them out the variables
                            .name(randomNames[rand.nextInt((4 - 1) + 1) + 1] + rand.nextInt((5 - 1) + 1) + 1)
                            .race(MONSTER)
                            .rarity(COMMON)
                            .imageUrl("No image")
                            .state(PASSIVE)
                            .build()
            );
        }
    }
}
