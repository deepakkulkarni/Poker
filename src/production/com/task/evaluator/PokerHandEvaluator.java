package com.task.evaluator;

import com.task.entity.Card;
import com.task.entity.PokerHand;

import java.util.*;

/**
 * Created by user on 6/25/2016.
 */
public class PokerHandEvaluator {

    public Card evaluateHighestRankCard(PokerHand pokerHand) {
        return Card.evaluateHighestRank(pokerHand.getCards());
    }

    public boolean isStraightHand(PokerHand pokerHand) {
        Card[] card = getSortedCardsArray(pokerHand);
        for (int idx = 1; idx < card.length; idx++) {
            if (card[idx].getRankValue() - card[idx - 1].getRankValue() != 1)
                return false;
        }
        return true;
    }

    public boolean isStraightFlushHand(PokerHand pokerHand) {
        Card[] card = getSortedCardsArray(pokerHand);
        for (int idx = 1; idx < card.length; idx++) {
            if (card[idx].getSuiteValue() != card[idx - 1].getSuiteValue() || card[idx].getRankValue() - card[idx - 1].getRankValue() != 1)
                return false;
        }
        return true;
    }

    public boolean isFlushHand(PokerHand pokerHand) {
        Card card[] = getSortedCardsArray(pokerHand);
        for (int idx = 1; idx < card.length; idx++) {
            if (card[idx].getSuiteValue() != card[idx - 1].getSuiteValue())
                return false;
        }
        return true;
    }

    public boolean isFourOfAKindHand(PokerHand pokerHand) {
        List<Card> cards = pokerHand.getCards();
        Set<Card> uniqueCards = new HashSet<>(cards);
        if (cards.size() - uniqueCards.size() == 3)
            return true;
        return false;
    }

    public boolean isThreeOfAKindHand(PokerHand pokerHand) {
        Card[] card = getSortedCardsArray(pokerHand);
        for (int idx = 0; idx < card.length; idx++) {
            int count = 0;
            for (int idy = 0; idy < card.length; idy++) {
                if (card[idx].getRankValue() == card[idy].getRankValue())
                    count++;
            }
            if (count == 3)
                return true;
        }
        return false;
    }

    public boolean isFullHouseHand(PokerHand pokerHand) {
        Card[] card = getSortedCardsArray(pokerHand);
        List<Card> pair = new ArrayList<>();

        for (int idx = 0; idx < card.length; idx++) {
            int count = 0;
            pair.clear();
            for (int idy = 0; idy < card.length; idy++) {
                if (card[idx].getRankValue() == card[idy].getRankValue()) {
                    count++;
                }
                else
                    pair.add(card[idy]);
            }
            if (count == 3) {
                if (pair.get(0).getRankValue() == pair.get(1).getRankValue())
                    return true;
            }
        }
        return false;
    }

    public boolean isTwoPairHand(PokerHand pokerHand) {
        Card[] card = getSortedCardsArray(pokerHand);
        List<Card> pair1 = new ArrayList<>(2);
        List<Card> pair2 = new ArrayList<>(2);

        for (int idx = 0; idx < card.length; idx++) {
            for (int idy = 0; idy < card.length; idy++) {
                if (idx != idy && card[idx].getRankValue() == card[idy].getRankValue()) {
                    if (pair1.size() != 2) {
                        pair1.add(card[idx]);
                        pair1.add(card[idy]);
                        break;
                    }
                    if (pair2.size() != 2 && !pair1.contains(card[idx])) {
                        pair2.add(card[idx]);
                        pair2.add(card[idy]);
                        break;
                    }
                }
            }
            if (pair1.size() == 2 && pair2.size() == 2)
                    return true;
        }
        return false;
    }

    public boolean isPairHand(PokerHand pokerHand) {
        Card[] card = getSortedCardsArray(pokerHand);
        for (int idx = 0; idx < card.length; idx++) {
            int count = 0;
            for (int idy = 0; idy < card.length; idy++) {
                if (card[idx].getRankValue() == card[idy].getRankValue())
                    count++;
            }
            if (count == 2)
                return true;
        }
        return false;

    }

    private Card[] getSortedCardsArray(PokerHand pokerHand) {
        List<Card> cards = Card.sortByRank(pokerHand.getCards());
        Card card[] = new Card[cards.size()];
        card = cards.toArray(card);
        return card;
    }


}
