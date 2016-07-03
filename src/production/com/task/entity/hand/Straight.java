package com.task.entity.hand;

import com.task.entity.Card;
import com.task.entity.PokerHand;
import com.task.util.Constants;

import java.util.List;

/**
 * Created by user on 6/30/2016.
 */
public class Straight extends PokerHand{

    public static final String handType = Constants.PARTIAL_ORDER.STRAIGHT.toString();

    public Straight(List<Card> cards) {
        super(cards,handType);
    }

    @Override
    public boolean evaluateRank() {
        Card[] card = getSortedCardsArray();
        for (int idx = 1; idx < card.length; idx++) {
            if (card[idx].getRankValue() - card[idx - 1].getRankValue() != 1)
                return false;
        }
        return true;
    }

}
