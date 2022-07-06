package com.cardgameproject.cardgame;


import com.cardgameproject.cardgame.entity.CreatureCard;
import com.cardgameproject.cardgame.repositories.CreatureCardRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.cardgameproject.cardgame.enums.raceType.MONSTER;
import static com.cardgameproject.cardgame.enums.rarityLevel.COMMON;
import static com.cardgameproject.cardgame.enums.stateType.ACTIVE;
import static com.cardgameproject.cardgame.enums.stateType.PASSIVE;

@SpringBootApplication
public class CardGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardGameApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner (CreatureCardRepository creatureRepository){
		return args -> {
			CreatureCard test =  CreatureCard.builder()
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
			creatureRepository.save(test);
		};
	}

}