package com.cardgameproject.cardgame.data;
import com.cardgameproject.cardgame.entity.*;
import com.cardgameproject.cardgame.repository.*;
import com.cardgameproject.cardgame.service.OriginalCardService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static com.cardgameproject.cardgame.enums.raceType.MONSTER;
import static com.cardgameproject.cardgame.enums.rarityLevel.COMMON;
import static com.cardgameproject.cardgame.enums.monsterStateType.PASSIVE;

@Component
public class SampleDataLoader implements CommandLineRunner {


    private final CreatureCardRepository cardRepository;
    private final DeckRepository deckRepository;
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private PasswordEncoder passwordEncoder;
    private final OriginalCardService originalCardService;
    private GameRepository gameRepository;
    private GameStateRepository gameStateRepository;


    public SampleDataLoader(CreatureCardRepository cardRepository, DeckRepository deckRepository, UserRepository userRepository, AuthorityRepository authorityRepository, PasswordEncoder passwordEncoder, OriginalCardRepository originalCardRepository, OriginalCardService originalCardService, GameRepository gameRepository, GameStateRepository gameStateRepository) {
        this.cardRepository = cardRepository;
        this.deckRepository = deckRepository;
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
        this.originalCardService = originalCardService;
        this.gameRepository = gameRepository;
        this.gameStateRepository = gameStateRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        passwordEncoder = new BCryptPasswordEncoder();
        List<DeckEntity> decks = new ArrayList<>();
        String encodedPassword = passwordEncoder.encode("1234");
        UserEntity user = UserEntity.builder()
                .username("test")
                .password(encodedPassword)
                .games(new ArrayList<>())
                .decks(decks)
                .build();
        userRepository.save(user);
        Authority auth = Authority.builder()
                .authority("ROLE_STUDENT")
                .user(user)
                .build();
        authorityRepository.save(auth);
        userRepository.save(user);
        List<CardEntity> sampleListOne = new ArrayList<>();
        List<CardEntity> sampleListTwo = new ArrayList<>();
        List<CardEntity> sampleListThree = new ArrayList<>();
        int amountOfCards = 10;
        String [] randomNames = {"SpookySkeleton", "BoogeyMan", "BigBadWolf", "ScaryGhost", "TerrificTroll"};
        String [] randomPictures = {"https://www.beholder.hu/pic/galeria/0497.jpg",
                "https://www.beholder.hu/pic/galeria/0465.jpg",
                "https://www.beholder.hu/pic/galeria/0464.jpg",
                "https://www.beholder.hu/pic/galeria/0451.jpg", "https://www.beholder.hu/pic/galeria/0420.jpg"};
        Random rand = new Random();
        int highestManaCost = 10;
        int highestBaseHealth = 10;
        int highestBaseAttack = 10;


        for(int i = 1; i < amountOfCards; i++) {

            CardEntity testCard = CardEntity.builder()
                    .baseAttack(rand.nextInt((highestBaseAttack - 1) + 1) + 1)
                    .baseHealth(rand.nextInt((highestBaseHealth - 1) + 1) + 1)
                    .canUseWeapon(true)
                    .description("This the test card number : " + i)
                    .manaCost(rand.nextInt((highestManaCost - 1) ) + 1)
                    .name(randomNames[rand.nextInt((randomNames.length - 1) ) + 1] + i)
                    .race(MONSTER)
                    .rarity(COMMON)
                    .imageUrl(randomPictures[rand.nextInt((randomPictures.length - 1) ) + 1])
                    .state(PASSIVE)
                    .decks(decks)
                    .build();
                cardRepository.save(testCard);
                sampleListOne.add(testCard);
                cardRepository.save(testCard);
        }


        DeckEntity sampleDeck1 = DeckEntity.builder()
                .deckName("Sampleone")
                .cards(sampleListOne)
                .user(user)
                .games(new ArrayList<>())
                .build();

        deckRepository.save(sampleDeck1);

        GameEntity game = GameEntity.builder()
                .gameStates(new ArrayList<>())
                .date(LocalDate.of(2022, 8, 11))
                .user(user)
                .deck(sampleDeck1)
                .build();
        user.addGame(game);
        gameRepository.save(game);
        userRepository.save(user);

        sampleDeck1.addGame(game);
        gameRepository.save(game);
        deckRepository.save(sampleDeck1);
        user.addDeck(sampleDeck1);
        DeckEntity sampleDeck2 = DeckEntity.builder()
                .deckName("Sampletwo")
                .cards(sampleListTwo)
                .user(user)
                .build();
        deckRepository.save(sampleDeck2);
        user.addDeck(sampleDeck2);

        DeckEntity sampleDeck3 = DeckEntity.builder()
                .deckName("Samplethree")
                .cards(sampleListThree)
                .user(user)
                .build();
        deckRepository.save(sampleDeck3);
        user.addDeck(sampleDeck3);


        GameStateEntity gameState = GameStateEntity.builder()
                .cardsInHand(new ArrayList<>())
                .gameEntity(game)
                .cardsOnTheBoard(sampleListOne)
                .playerHealth(10)
                .mana(5)
                .gameTurn(3)
                .build();
        game.addGameState(gameState);
        gameStateRepository.save(gameState);
//        gameRepository.save(game);
        originalCardService.createAllOriginalCards();

    }
}

