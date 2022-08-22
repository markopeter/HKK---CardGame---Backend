package com.cardgameproject.cardgame.service;
import com.cardgameproject.cardgame.dto.CardDto;
import com.cardgameproject.cardgame.entity.CardEntity;
import com.cardgameproject.cardgame.repository.CreatureCardRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreatureCardService {

    private CreatureCardRepository creatureRepository;
    private ModelMapper modelMapper;
    @Autowired
    public CreatureCardService(CreatureCardRepository creatureRepository, ModelMapper modelMapper) {
        this.creatureRepository = creatureRepository;
        this.modelMapper = modelMapper;
    }

    public List<CardDto> getAllCreatures(){
        List<CardEntity> cards = (List<CardEntity>) creatureRepository.findAll();
               return cards.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    public void addCreatureCard(CardEntity card){
        creatureRepository.save(card);
    }
    public CardDto findCreatureCardByName(String name){
        return convertToDto(creatureRepository.findCreatureCardByName(name));
    }
    public List<CardDto> findCardsByNameAndManaCost (String name, int manaCost){
        List<CardEntity> cards =  creatureRepository.findCreatureCardByNameAndManaCost(name, manaCost);
        return cards.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public List<CardDto> findCardsByDetail(String detail, String value){
        switch(detail){
            case "name":
                return creatureRepository.findAllByName(value).stream()
                        .map(this::convertToDto)
                        .collect(Collectors.toList());
            case "manaCost":
                return creatureRepository.findAllByManaCost(Integer.parseInt(value)).stream()
                        .map(this::convertToDto)
                        .collect(Collectors.toList());
            case "baseAttack":
                return creatureRepository.findAllBybaseAttack(Integer.parseInt(value)).stream()
                        .map(this::convertToDto)
                        .collect(Collectors.toList());
            case "baseHealth":
                return creatureRepository.findAllBybaseHealth(Integer.parseInt(value)).stream()
                        .map(this::convertToDto)
                        .collect(Collectors.toList());
            default:
                System.out.println("No card found !");
        }
        return null;
    }
    private CardDto convertToDto(CardEntity card) {
        return modelMapper.map(card, CardDto.class);
    }

}
