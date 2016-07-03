package com.task.entity.hand;

import com.task.entity.Card;
import com.task.entity.PokerHand;
import com.task.util.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 6/30/2016.
 */
public class FullHouse extends PokerHand{

    public static final String handType = Constants.PARTIAL_ORDER.FULL_HOUSE.toString();

    public FullHouse(List<Card> cards) {
        super(cards,handType);
    }

    @Override
    public boolean evaluateRank() {
        Card[] card = getSortedCardsArray();
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
}
