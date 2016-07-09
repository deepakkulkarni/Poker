package com.task.poker.entity;

import com.task.poker.evaluator.Evaluator;
import com.task.poker.util.Constants;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by user on 6/25/2016.
 */
public class PokerHand implements Evaluator {

    public static final int size = 5;
    private final List<Card> cards;
    private List<Card> originalCards;
    private String handType;
    private final Comparator<Card> byRank = (c1, c2) -> Integer.compare(Constants.RANK.valueOf(c1.getRank()).getValue(), Constants.RANK.valueOf(c2.getRank()).getValue());

    public PokerHand(List<Card> cards) {
        this.cards = cards;
        this.originalCards = new ArrayList<>(cards);
    }

    public PokerHand(List<Card> cards, String handType) {
        this.cards = cards;
        this.handType = handType;
    }

    protected Card[] getSortedCardsArray() {
        List<Card> cards = Card.sortByRank(this.getCards());
        Card card[] = new Card[cards.size()];
        card = cards.toArray(card);
        return card;
    }

    public String getHandType() {
        return handType;
    }

    public List<Card> getCards() {
        return cards;
    }

    protected void sortCardsByRank() {
        getCards().sort(byRank);
    }

    public void listCards() {
        originalCards.forEach(System.out::println);
    }
}
