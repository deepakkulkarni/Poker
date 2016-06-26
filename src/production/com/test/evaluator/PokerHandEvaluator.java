package com.test.evaluator;

import com.test.entity.Card;
import com.test.entity.PokerHand;

import java.util.List;

/**
 * Created by user on 6/25/2016.
 */
public class PokerHandEvaluator {

    public Card evaluateHighestRankCard(PokerHand pokerHand) {
        return Card.evaluateHighestRank(pokerHand.getCards());
    }

    public boolean isStraightHand(PokerHand pokerHand) {
        return isConsecutiveSequence(pokerHand);

    }

    public boolean isStraightFlushHand(PokerHand pokerHand) {
        return isConsecutiveSequenceWithSameRank(pokerHand);
    }

    private boolean isConsecutiveSequence(PokerHand pokerHand) {
        boolean isStraight = true;
        List<Card> cards = Card.sortByRank(pokerHand.getCards());
        Card card[] = new Card[cards.size()];
        card = cards.toArray(card);
        for (int idx = 1; idx < card.length; idx++) {
            if(card[idx].getRankValue() - card[idx - 1].getRankValue() != 1) {
                isStraight = false;
                break;
            }
        }
        return isStraight;
    }

    private boolean isConsecutiveSequenceWithSameRank(PokerHand pokerHand) {
        boolean isStraightFlush = true;
        List<Card> cards = Card.sortByRank(pokerHand.getCards());
        Card card[] = new Card[cards.size()];
        card = cards.toArray(card);
        for (int idx = 1; idx < card.length; idx++) {
            if(card[idx].getSuiteValue() != card[idx - 1].getSuiteValue() && card[idx].getRankValue() - card[idx - 1].getRankValue() != 1) {
                isStraightFlush = false;
                break;
            }
        }
        return isStraightFlush;
    }
}
