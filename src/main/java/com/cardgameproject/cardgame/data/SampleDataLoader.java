package com.cardgameproject.cardgame.data;

import com.cardgameproject.cardgame.repositories.CreatureCardRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleDataLoader implements CommandLineRunner {


    private final CreatureCardRepository cardRepository;
    private final Faker faker;

    public SampleDataLoader(CreatureCardRepository cardRepository, Faker faker) {
        this.cardRepository = cardRepository;
        this.faker = faker;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
