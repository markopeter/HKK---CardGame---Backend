package com.cardgameproject.cardgame.data;

import com.cardgameproject.cardgame.entity.CreatureCard;
import com.cardgameproject.cardgame.repositories.CreatureCardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static com.cardgameproject.cardgame.enums.raceType.MONSTER;
import static com.cardgameproject.cardgame.enums.rarityLevel.COMMON;
import static com.cardgameproject.cardgame.enums.stateType.ACTIVE;

@Component
public class SampleDataLoader implements CommandLineRunner {


    private CreatureCardRepository cardRepository;

    public SampleDataLoader(CreatureCardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public void run(String... args) throws Exception {
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
                .imageUrl("https://www.beholder.hu/pic/galeria/0567.jpg")
                .build();
        cardRepository.save(test1);
        cardRepository.save(test2);
    }
}
