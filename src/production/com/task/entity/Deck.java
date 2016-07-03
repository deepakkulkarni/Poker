package com.task.entity;

import com.task.util.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 6/25/2016.
 */
public class Deck {
    private List<Card> cards = new ArrayList();

    public Deck() {
        initializeCards(cards);
    }

    public List<Card> getCards() {
        return cards;
    }

    private void initializeCards(List cards) {
        for (int suiteIndex = 0; suiteIndex < Constants.SUITE.values().length; suiteIndex++) {
            for (int rankIndex = 0; rankIndex < Constants.RANK.values().length; rankIndex++) {
                Card card = new Card(Constants.SUITE.values()[suiteIndex].toString(), Constants.RANK.values()[rankIndex].toString());
                cards.add(card);
            }
        }
    }
}
