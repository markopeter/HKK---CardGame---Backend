package com.cardgameproject.cardgame.service;

import com.cardgameproject.cardgame.entity.OriginalCard;
import com.cardgameproject.cardgame.repository.OriginalCardRepository;
import com.cardgameproject.cardgame.util.WebScrapper;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class OriginalCardService {

    private final OriginalCardRepository originalCardRepository;
    private final WebScrapper webScrapper;

    @Autowired
    public OriginalCardService(OriginalCardRepository originalCardRepository, WebScrapper webScrapper) {
        this.originalCardRepository = originalCardRepository;
        this.webScrapper = webScrapper;
    }

    public List<OriginalCard> createAllOriginalCards() throws IOException {
       List<OriginalCard> cards = new ArrayList<>();

       Elements allCards = webScrapper.getOriginalCards(
               "http://beholder.hu/?m=hkk&in=hkk_lapkereso.php&KERESES=1&szin1=0&tipus1=0&nevstr=&szovegstr=");
       int cardLimit = 30;
       int cardCounter = 0;
        for (Element element : allCards) {
                if(cardCounter == cardLimit){
                    break;
                }
                OriginalCard originalCard = OriginalCard.builder()
                        .name(element.text())
                        .picUrl(element.attr("href"))
                        .build();
                originalCardRepository.save(originalCard);
                cards.add(originalCard);
                cardCounter++;
        }
        return cards;
    }

    public List<OriginalCard> getAllOriginalCard(){
        return (List<OriginalCard>) originalCardRepository.findAll();
    }
}
