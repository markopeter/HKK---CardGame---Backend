package com.cardgameproject.cardgame.util;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class WebScrapper {

    public  Elements getOriginalCards(String url)  {
        Connection conn = Jsoup.connect(url);
        Document document = null;
        conn.userAgent("custom user agent");
        Elements cardHtml = null;
        try {
            document = conn.get();
            cardHtml = document.getElementsByClass("lapnw myTooltip");
        } catch (IOException e) {
            e.printStackTrace();
            //TODO handle error
        }
        return cardHtml;
    }

}
