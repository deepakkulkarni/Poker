package com.task.entity.hand;

import com.task.entity.Card;
import com.task.entity.PokerHand;
import com.task.util.Constants;

import java.util.List;

/**
 * Created by user on 6/30/2016.
 */
public class FourOfAKind extends PokerHand {

    public static final String handType = Constants.PARTIAL_ORDER.FOUR_OF_A_KIND.toString();

    public FourOfAKind(List<Card> cards) {
        super(cards,handType);
    }

    @Override
    public boolean evaluateRank() {
        Card[] card = getSortedCardsArray();
        for (int idx = 0; idx < card.length; idx++) {
            int count = 0;
            for (int idy = 0; idy < card.length; idy++) {
                if (card[idx].getRankValue() == card[idy].getRankValue())
                    count++;
            }
            if (count == 4)
                return true;
        }
        return false;
    }

}
