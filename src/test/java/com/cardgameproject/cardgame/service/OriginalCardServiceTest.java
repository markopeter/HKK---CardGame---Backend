package com.cardgameproject.cardgame.service;

import com.cardgameproject.cardgame.entity.OriginalCard;
import com.cardgameproject.cardgame.repository.OriginalCardRepository;
import com.cardgameproject.cardgame.util.WebScrapper;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class OriginalCardServiceTest {

    @Mock
    private OriginalCardRepository originalCardRepository;
    @Mock
    private WebScrapper webScrapper;
    @InjectMocks
    private OriginalCardService service;

    Elements elements;

    @BeforeEach
    void setup(){
        elements = new Elements();
        Element element1 = new Element("tr");
        Element element2 = new Element("tr");
        element1.text("Card1");
        element2.text("Card2");
        element1.attr("href", "testurl1");
        element2.attr("href", "testurl2");
        elements.add(element1);
        elements.add(element2);
    }


    @Test
    void createAllOriginalCards() throws IOException {
        lenient().when(webScrapper.getOriginalCards("http://beholder.hu/?m=hkk&in=hkk_lapkereso.php&KERESES=1&szin1=0&tipus1=0&nevstr=&szovegstr="))
                .thenReturn(elements);

        List<OriginalCard> cardList;
        OriginalCard originalCard1 = OriginalCard.builder()
                .name(elements.get(0).text())
                .picUrl(elements.get(0).attr("href"))
                .build();
        OriginalCard originalCard2 = OriginalCard.builder()
                .name(elements.get(1).text())
                .picUrl(elements.get(1).attr("href"))
                .build();
        cardList = new ArrayList<>();
        cardList.add(originalCard1);
        cardList.add(originalCard2);

        assertThat(cardList).isNotNull().isNotEmpty().hasSize(2);
    }

    @Test
    void getAllOriginalCard() {

    }
}