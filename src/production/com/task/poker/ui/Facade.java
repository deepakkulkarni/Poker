package com.task.poker.ui;

import com.task.poker.entity.Card;
import com.task.poker.entity.Deck;
import com.task.poker.util.Constants;

import java.util.List;
import java.util.Set;

/**
 * Created by user on 7/9/2016.
 */
public class Facade {

    public String[] getHandsWithOneDeck() {
        Deck deck = new Deck();
        String hand[] = new String[10];
        int idx = 0;
        Set<Card> cards = deck.drawCards(10);
        for(Card card: cards) {
            String suite = Constants.SUITE.valueOf(card.getSuite()).getAbbreviation();
            String rank = Constants.RANK.valueOf(card.getRank()).getAbbreviation();
            hand[idx] = suite + rank;
            idx++;
        }
        return hand;
    }

    public String[] getHandsWithMultipleDecks() {
        String hand1[] = getHand();
        String hand2[] = getHand();
        String[] hand = new String[hand1.length + hand2.length];
        System.arraycopy(hand1, 0, hand, 0, hand1.length);
        System.arraycopy(hand2, 0, hand, hand1.length, hand2.length);
        return hand;
    }

    private String[] getHand() {
        String[] hand = new String[5];
        int idx = 0;
        Deck deck = new Deck();
        Set<Card> cards = deck.drawCards(5);
        for(Card card: cards) {
            String suite = Constants.SUITE.valueOf(card.getSuite()).getAbbreviation();
            String rank = Constants.RANK.valueOf(card.getRank()).getAbbreviation();
            hand[idx] = suite + rank;
            idx++;
        }
        return hand;
    }



}
