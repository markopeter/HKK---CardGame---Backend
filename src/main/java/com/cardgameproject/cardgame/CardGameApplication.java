package com.cardgameproject.cardgame;


import com.cardgameproject.cardgame.entity.CreatureCard;
import com.cardgameproject.cardgame.repositories.CreatureCardRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

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
			CreatureCard test2 =  CreatureCard.builder()
					.baseAttack(10)
					.baseHealth(10)
					.canUseWeapon(false)
					.description("Test")
					.manaCost(2)
					.name("SpookeySkeleton")
					.race(MONSTER)
					.rarity(COMMON)
					.state(ACTIVE)
					.build();
			creatureRepository.save(test);
			creatureRepository.save(test2);
		};
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(List.of("https://hkk-petproject.herokuapp.com/creatures"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS"));
		configuration.setAllowedHeaders(Arrays.asList("Access-Control-Allow-Headers", "Access-Control-Allow-Origin",
				"Access-Control-Request-Method", "Access-Control-Request-Headers", "Origin",
				"Cache-Control", "Content-Type"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

}
