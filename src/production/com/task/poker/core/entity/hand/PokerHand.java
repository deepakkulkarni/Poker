package com.task.poker.core.entity.hand;

import com.task.poker.core.entity.Card;
import com.task.poker.core.evaluator.Evaluator;
import com.task.poker.util.Constants;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by user on 6/25/2016.
 */
public class PokerHand implements Evaluator {

    private static final Logger logger = Logger.getLogger(PokerHand.class);

    private final Comparator<Card> byRank = (c1, c2) -> Integer.compare(Constants.RANK.valueOf(c1.getRank()).getValue(), Constants.RANK.valueOf(c2.getRank()).getValue());
    private final List<Card> cards;
    private List<Card> originalCards;
    private String handType;

    public PokerHand(List<Card> cards) {
        this.cards = cards;
        this.originalCards = new ArrayList<>(cards);
    }

    public PokerHand(List<Card> cards, String handType) {
        this.cards = cards;
        this.handType = handType;
    }

    public void listCards() {
        originalCards.forEach(card -> logger.info(card.toString()));
    }

    public String getHandType() {
        return handType;
    }

    public List<Card> getCards() {
        return cards;
    }

    public List<Card> getOriginalCards() {
        return originalCards;
    }

    protected void sortCardsByRank() {
        getCards().sort(byRank);
    }

    protected Card[] getSortedCardsArray() {
        List<Card> cards = Card.sortByRank(this.getCards());
        Card card[] = new Card[cards.size()];
        card = cards.toArray(card);
        return card;
    }
}
