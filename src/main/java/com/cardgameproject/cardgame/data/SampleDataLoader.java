package com.cardgameproject.cardgame.data;
import com.cardgameproject.cardgame.entity.Authority;
import com.cardgameproject.cardgame.entity.UserEntity;
import com.cardgameproject.cardgame.repository.AuthorityRepository;
import com.cardgameproject.cardgame.repository.CreatureCardRepository;
import com.cardgameproject.cardgame.repository.DeckRepository;
import com.cardgameproject.cardgame.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;

@Component
public class SampleDataLoader implements CommandLineRunner {


    private final CreatureCardRepository cardRepository;
    private final DeckRepository deckRepository;
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private PasswordEncoder passwordEncoder;

    public SampleDataLoader(CreatureCardRepository cardRepository, DeckRepository deckRepository, UserRepository userRepository, AuthorityRepository authorityRepository, PasswordEncoder passwordEncoder) {
        this.cardRepository = cardRepository;
        this.deckRepository = deckRepository;
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode("1234");
        System.out.println(encodedPassword);
        UserEntity user = UserEntity.builder()
                .username("test")
                .password(encodedPassword)
                .build();
        userRepository.save(user);
        Authority auth = Authority.builder()
                .authority("ROLE_STUDENT")
                .user(user)
                .build();
        authorityRepository.save(auth);
        userRepository.save(user);
        System.out.println(user.getPassword());
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
    }
}
