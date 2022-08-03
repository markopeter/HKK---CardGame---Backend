package com.cardgameproject.cardgame.data;
import com.cardgameproject.cardgame.entity.Card;
import com.cardgameproject.cardgame.entity.DeckEntity;
import com.cardgameproject.cardgame.repository.CreatureCardRepository;
import com.cardgameproject.cardgame.repository.DeckRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.cardgameproject.cardgame.enums.raceType.MONSTER;
import static com.cardgameproject.cardgame.enums.rarityLevel.COMMON;
import static com.cardgameproject.cardgame.enums.stateType.PASSIVE;

//@Component
//public class SampleDataLoader implements CommandLineRunner {


//    private final CreatureCardRepository cardRepository;
//    private final DeckRepository deckRepository;
//
//    public SampleDataLoader(CreatureCardRepository cardRepository, DeckRepository deckRepository) {
//        this.cardRepository = cardRepository;
//        this.deckRepository = deckRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        List<Card> sampleListOne = new ArrayList<>();
//        List<Card> sampleListTwo = new ArrayList<>();
//        List<Card> sampleListThree = new ArrayList<>();
//        int amountOfCards = 100;
//        String [] randomNames = {"SpookySkeleton", "BoogeyMan", "BigBadWolf", "ScaryGhost", "TerrificTroll"};
//        String [] randomPictures = {"https://www.beholder.hu/pic/galeria/0497.jpg",
//                "https://www.beholder.hu/pic/galeria/0465.jpg",
//                "https://www.beholder.hu/pic/galeria/0464.jpg",
//        "https://www.beholder.hu/pic/galeria/0451.jpg", "https://www.beholder.hu/pic/galeria/0420.jpg"};
//        Random rand = new Random();
//        for(int i = 0; i < amountOfCards; i++) {
//
//            Card testCard = Card.builder()
//                    .baseAttack(rand.nextInt((10 - 1) + 1) + 1)
//                    .baseHealth(rand.nextInt((10 - 1) + 1) + 1)
//                    .canUseWeapon(true)
//                    .description("This the test card number : " + i)
//                    .manaCost(rand.nextInt((10 - 1) + 1) + 1)
//                    //TODO
//                    //Get rid of magic numbers, extract them out the variables
//                    .name(randomNames[rand.nextInt((4 - 1) + 1) + 1] + i)
//                    .race(MONSTER)
//                    .rarity(COMMON)
//                    .imageUrl(randomPictures[rand.nextInt((4 - 1) + 1) + 1])
//                    .state(PASSIVE)
//                    .build();
//
//            cardRepository.save(testCard);
//            if(i % 3 == 0){
//                sampleListOne.add(testCard);
//            }
//            if(i % 4 == 0){
//                sampleListTwo.add(testCard);
//            }
//            if(i % 5 == 0){
//                sampleListThree.add(testCard);
//            }
//        }
//
//
//        DeckEntity sampleDeck1 = DeckEntity.builder()
//                .deckName("Sampleone")
//                .cards(sampleListOne)
//                .build();
//        DeckEntity sampleDeck2 = DeckEntity.builder()
//                .deckName("Sampletwo")
//                .cards(sampleListTwo)
//                .build();
//        DeckEntity sampleDeck3 = DeckEntity.builder()
//                .deckName("Samplethree")
//                .cards(sampleListThree)
//                .build();
//        deckRepository.save(sampleDeck1);
//        deckRepository.save(sampleDeck2);
//        deckRepository.save(sampleDeck3);
//
//    }
//}
