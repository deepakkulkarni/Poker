package com.task.poker.core.entity;

import com.task.poker.util.Constants;
import java.util.*;

/**
 * Created by user on 6/25/2016.
 */
public class Deck {
    private List<Card> cards = new ArrayList<>();

    public Deck() {
        initialize(cards);
    }

    public Set<Card> drawCards(int noOfCards) {
        Set<Card> cardsDrawn = new HashSet<>();
        while (true) {
            int suiteIndex = new Random().nextInt(Constants.SUITE.values().length);
            int rankIndex = new Random().nextInt(Constants.RANK.values().length);
            Card card = new Card(Constants.SUITE.values()[suiteIndex].toString(), Constants.RANK.values()[rankIndex].toString());
            cardsDrawn.add(card);
            cards.remove(card);
            if (cardsDrawn.size() >= noOfCards)
                break;
        }
        return cardsDrawn;
    }

    private void initialize(List<Card> cards) {
        for (int suiteIndex = 0; suiteIndex < Constants.SUITE.values().length; suiteIndex++) {
            for (int rankIndex = 0; rankIndex < Constants.RANK.values().length; rankIndex++) {
                Card card = new Card(Constants.SUITE.values()[suiteIndex].toString(), Constants.RANK.values()[rankIndex].toString());
                cards.add(card);
            }
        }
    }

    public List<Card> getCards() {
        return cards;
    }
}
