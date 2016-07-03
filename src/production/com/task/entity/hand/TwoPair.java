package com.task.entity.hand;

import com.task.entity.Card;
import com.task.entity.PokerHand;
import com.task.util.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 6/30/2016.
 */
public class TwoPair extends PokerHand {

    public static final String handType = Constants.PARTIAL_ORDER.TWO_PAIRS.toString();

    public TwoPair(List<Card> cards) {
        super(cards,handType);
    }

    @Override
    public boolean evaluateRank() {
        Card[] card = getSortedCardsArray();
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

}
