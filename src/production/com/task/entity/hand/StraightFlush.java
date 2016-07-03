package com.task.entity.hand;

import com.task.entity.Card;
import com.task.entity.PokerHand;
import com.task.util.Constants;

import java.util.List;

/**
 * Created by user on 6/30/2016.
 */
public class StraightFlush extends PokerHand{

    public static final String handType = Constants.PARTIAL_ORDER.STRAIGHT_FLUSH.toString();

    public StraightFlush(List<Card> cards) {
        super(cards,handType);
    }

    public boolean evaluateRank() {
        Card[] card = getSortedCardsArray();
        for (int idx = 1; idx < card.length; idx++) {
            if (card[idx].getSuiteValue() != card[idx - 1].getSuiteValue() || card[idx].getRankValue() - card[idx - 1].getRankValue() != 1)
                return false;
        }
        return true;
    }

}
