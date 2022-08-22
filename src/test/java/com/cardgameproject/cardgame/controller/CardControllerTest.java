package com.cardgameproject.cardgame.controller;

import com.cardgameproject.cardgame.dto.CardDto;
import com.cardgameproject.cardgame.entity.CardEntity;
import com.cardgameproject.cardgame.repository.CreatureCardRepository;
import com.cardgameproject.cardgame.service.CreatureCardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;


import java.util.ArrayList;
import java.util.List;

import static com.cardgameproject.cardgame.enums.raceType.MONSTER;
import static com.cardgameproject.cardgame.enums.rarityLevel.COMMON;
import static com.cardgameproject.cardgame.enums.stateType.PASSIVE;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CardControllerTest {

    @Mock
    private CreatureCardRepository cardRepo;
    @InjectMocks
    private CreatureCardService service;

    private ModelMapper mapper;
    private CardEntity card;
    private CardEntity cardTwo;
    private List<CardDto> cards;
    @BeforeEach
     void setup(){
        mapper = new ModelMapper();
        card = CardEntity.builder()
                .id(1L)
                .baseAttack(1)
                .baseHealth( 1)
                .canUseWeapon(true)
                .description("Test card description")
                .manaCost( 1)
                .name("Testname")
                .race(MONSTER)
                .rarity(COMMON)
                .imageUrl("image")
                .state(PASSIVE)
                .build();
        cardTwo = CardEntity.builder()
                .id(2L)
                .baseAttack(2)
                .baseHealth( 2)
                .canUseWeapon(true)
                .description("Test card description two")
                .manaCost( 2)
                .name("TestnameTwo")
                .race(MONSTER)
                .rarity(COMMON)
                .imageUrl("imageTwo")
                .state(PASSIVE)
                .build();
        cards = new ArrayList<>();
        cards.add(mapper.map(card, CardDto.class));
        cards.add(mapper.map(cardTwo, CardDto.class));
    }

    @Test
    void getCreatureCardByName() {

        CardDto cardDto = mapper.map(card, CardDto.class);
        assertEquals(card.getId(), cardDto.getId());
        assertEquals(card.getName(), cardDto.getName());
        assertEquals(card.getImageUrl(), cardDto.getImageUrl());

    }

    @Test
    void getAllCreatures() {
        assertEquals(2, cards.size());
        assertEquals("TestnameTwo", cards.get(1).getName());
        assertNotNull(cards.get(0));
    }

    @Test
    void getAllCardByNameAndManaCost() {
        List<CardDto> searchResult = new ArrayList<>();
        searchResult.add(mapper.map(cardTwo, CardDto.class));
        assertEquals(1, searchResult.size());
        assertEquals("TestnameTwo", searchResult.get(0).getName());
    }

}