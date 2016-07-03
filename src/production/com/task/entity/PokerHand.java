package com.task.entity;

import com.task.evaluator.Evaluator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by user on 6/25/2016.
 */
public class PokerHand implements Evaluator {

    private final List<Card> cards;
    private String handType;
    private int finalRank;
    private int finalValue;

    public static final Comparator<PokerHand> byFinalRank = (hand1, hand2) -> Integer.compare(hand1.getFinalRank(), hand2.getFinalRank());

    public PokerHand(List<Card> cards, String handType) {
        this.cards = cards;
        this.handType = handType;
    }

    public static List<PokerHand> sortByFinalRank(List<PokerHand> pokerHands) {
        Collections.sort(pokerHands, byFinalRank);
        return pokerHands;
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

    public PokerHand(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getFinalRank() {
        return finalRank;
    }

    public void setFinalRank(int finalRank) {
        this.finalRank = finalRank;
    }

    public int getFinalValue() {
        return finalValue;
    }

    public void setFinalValue(int finalValue) {
        this.finalValue = finalValue;
    }
}
