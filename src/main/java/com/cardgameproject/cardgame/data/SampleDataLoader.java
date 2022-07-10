package com.cardgameproject.cardgame.data;

import com.cardgameproject.cardgame.entity.CreatureCard;
import com.cardgameproject.cardgame.repositories.CreatureCardRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

@Component
public class SampleDataLoader implements CommandLineRunner {


    private final CreatureCardRepository cardRepository;

    public SampleDataLoader(CreatureCardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
